package interfazApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.jdo.JDODataStoreException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import negocio.HotelAndes;
import negocio.VOReserva;
import negocio.VOReservaServicio;

public class InterfazHotelAndesApp extends JFrame implements ActionListener 
{
	// ---------------------------------------------------------------
	// -------------------------Constantes----------------------------
	// ---------------------------------------------------------------
	/**
	 * Logger para escribir la traza de la ejecucion
	 */
	private static Logger log = Logger.getLogger(InterfazHotelAndesApp.class.getName());

	/**
	 * Ruta al archivo de configuraci�n de la interfaz
	 */
	private static final String CONFIG_INTERFAZ = "./src/main/resources/config/interfaceConfigApp.json";

	/**
	 * Ruta al archivo de configuraci�n de los nombres de tablas de la base de datos
	 */
	private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json";

	// ---------------------------------------------------------------
	// --------------------------Atributos----------------------------
	// ---------------------------------------------------------------
	/**
	 * Objeto JSON con los nombres de las tablas de la base de datos que se quieren
	 * utilizar
	 */
	private JsonObject tableConfig;

	/**
	 * Asociaci�n a la clase principal del negocio.
	 */
	private HotelAndes hotelAndes;

	/**
	 * Objeto JSON con la configuraci�n de interfaz de la app.
	 */
	private JsonObject guiConfig;

	/**
	 * Panel de despliegue de interacci�n para los requerimientos
	 */
	private PanelDatos panelDatos;

	/**
	 * Men� de la aplicaci�n
	 */
	private JMenuBar menuBar;

	// ---------------------------------------------------------------
	// ------------------------Constructores--------------------------
	// ---------------------------------------------------------------
	public InterfazHotelAndesApp() {
		// Carga la configuraci�n de la interfaz desde un archivo JSON
		guiConfig = openConfig("Interfaz", CONFIG_INTERFAZ);

		// Configura la apariencia del frame que contiene la interfaz gr�fica
		configurarFrame();
		if (guiConfig != null) {
			crearMenu(guiConfig.getAsJsonArray("menuBar"));
		}

		tableConfig = openConfig("Tablas BD", CONFIG_TABLAS);
		hotelAndes = new HotelAndes(tableConfig);

		String path = guiConfig.get("bannerPath").getAsString();
		panelDatos = new PanelDatos();

		setLayout(new BorderLayout());
		add(new JLabel(new ImageIcon(path)), BorderLayout.NORTH);
		add(panelDatos, BorderLayout.CENTER);
	}

	// ---------------------------------------------------------------
	// ---------------------------Metodos-----------------------------
	// ---------------------------------------------------------------
	/**
	 * Lee datos de configuraci�n para la aplicaci�, a partir de un archivo JSON o
	 * con valores por defecto si hay errores.
	 * 
	 * @param tipo       - El tipo de configuraci�n deseada
	 * @param archConfig - Archivo Json que contiene la configuraci�n
	 * @return Un objeto JSON con la configuraci�n del tipo especificado NULL si hay
	 *         un error en el archivo.
	 */
	private JsonObject openConfig(String tipo, String archConfig) {
		JsonObject config = null;
		try {
			Gson gson = new Gson();
			FileReader file = new FileReader(archConfig);
			JsonReader reader = new JsonReader(file);
			config = gson.fromJson(reader, JsonObject.class);
			log.info("Se encontr� un archivo de configuraci�n v�lido: " + tipo);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("NO se encontr� un archivo de configuraci�n v�lido");
			JOptionPane.showMessageDialog(null,
					"No se encontr� un archivo de configuraci�n de interfaz v�lido: " + tipo, "Parranderos App",
					JOptionPane.ERROR_MESSAGE);
		}
		return config;
	}

	/**
	 * M�todo para configurar el frame principal de la aplicaci�n
	 */
	private void configurarFrame() {
		int alto = 0;
		int ancho = 0;
		String titulo = "";

		if (guiConfig == null) {
			log.info("Se aplica configuracion por defecto");
			titulo = "HotelAndes APP Default";
			alto = 300;
			ancho = 500;
		} else {
			log.info("Se aplica configuracion indicada en el archivo de configuracion");
			titulo = guiConfig.get("title").getAsString();
			alto = guiConfig.get("frameH").getAsInt();
			ancho = guiConfig.get("frameW").getAsInt();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(50, 50);
		setResizable(true);
		setBackground(Color.WHITE);

		setTitle(titulo);
		setSize(ancho, alto);
	}

	/**
	 * M�todo para crear el men� de la aplicaci�n con base em el objeto JSON le�do
	 * Genera una barra de men� y los men�s con sus respectivas opciones
	 * 
	 * @param jsonMenu - Arreglo Json con los men�s deseados
	 */
	private void crearMenu(JsonArray jsonMenu) {
		// Creaci�n de la barra de men�s
		menuBar = new JMenuBar();
		for (JsonElement men : jsonMenu) {
			// Creaci�n de cada uno de los men�s
			JsonObject jom = men.getAsJsonObject();

			String menuTitle = jom.get("menuTitle").getAsString();
			JsonArray opciones = jom.getAsJsonArray("options");

			JMenu menu = new JMenu(menuTitle);

			for (JsonElement op : opciones) {
				// Creaci�n de cada una de las opciones del men�
				JsonObject jo = op.getAsJsonObject();
				String lb = jo.get("label").getAsString();
				String event = jo.get("event").getAsString();

				JMenuItem mItem = new JMenuItem(lb);
				mItem.addActionListener(this);
				mItem.setActionCommand(event);

				menu.add(mItem);
			}
			menuBar.add(menu);
		}
		setJMenuBar(menuBar);
	}

	/**
	 * Muestra el log de Parranderos
	 */
	public void mostrarLogParranderos() {
		mostrarArchivo("parranderos.log");
	}

	/**
	 * Muestra el log de datanucleus
	 */
	public void mostrarLogDatanuecleus() {
		mostrarArchivo("datanucleus.log");
	}

	/**
	 * Limpia el contenido del log de parranderos Muestra en el panel de datos la
	 * traza de la ejecuci�n
	 */
	public void limpiarLogParranderos() {
		// Ejecuci�n de la operaci�n y recolecci�n de los resultados
		boolean resp = limpiarArchivo("parranderos.log");

		// Generaci�n de la cadena de caracteres con la traza de la ejecuci�n de la demo
		String resultado = "\n\n----------Limpiando el log de parranderos----------\n";
		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);
	}

	/**
	 * Genera una cadena de caracteres con la descripci�n de la excepcion e,
	 * haciendo �nfasis en las excepcionsde JDO
	 * 
	 * @param e - La excepci�n recibida
	 * @return La descripci�n de la excepci�n, cuando es
	 *         javax.jdo.JDODataStoreException, "" de lo contrario
	 */
	private String darDetalleException(Exception e) {
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException")) {
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions()[0].getMessage();
		}
		return resp;
	}

	/**
	 * Genera una cadena para indicar al usuario que hubo un error en la aplicaci�n
	 * 
	 * @param e - La excepci�n generada
	 * @return La cadena con la informaci�n de la excepci�n y detalles adicionales
	 */
	private String generarMensajeError(Exception e) {
		String resultado = "--------Error en la ejecucion--------\n";
		resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
		resultado += "\n\nRevise datanucleus.log y parranderos.log para m�s detalles";
		return resultado;
	}

	/**
	 * Limpia el contenido de un archivo dado su nombre
	 * 
	 * @param nombreArchivo - El nombre del archivo que se quiere borrar
	 * @return true si se pudo limpiar
	 */
	private boolean limpiarArchivo(String nombreArchivo) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(new File(nombreArchivo)));
			bw.write("");
			bw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Abre el archivo dado como par�metro con la aplicaci�n por defecto del sistema
	 * 
	 * @param nombreArchivo - El nombre del archivo que se quiere mostrar
	 */
	private void mostrarArchivo(String nombreArchivo) {
		try {
			Desktop.getDesktop().open(new File(nombreArchivo));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * M�todo para la ejecuci�n de los eventos que enlazan el men� con los m�todos
	 * de negocio Invoca al m�todo correspondiente seg�n el evento recibido
	 * 
	 * @param pEvento - El evento del usuario
	 */
	@Override
	public void actionPerformed(ActionEvent pEvento) {
		String evento = pEvento.getActionCommand();
		try {
			Method req = InterfazHotelAndesApp.class.getMethod(evento);
			req.invoke(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void realizarUnaReserva()
    {
    	try 
    	{
    		String tipoDocumento = JOptionPane.showInputDialog (this, "Ingrese el numero de su tipo Documento: 1.CC 2.NIT 3.TI", "Realizar una reserva", JOptionPane.QUESTION_MESSAGE);
    		String numeroDocumento = JOptionPane.showInputDialog (this, "Numero de documento", "Realizar una reserva", JOptionPane.QUESTION_MESSAGE);
    		String numeroHabitacion = JOptionPane.showInputDialog (this, "Habitacion deseada", "Realizar una reserva", JOptionPane.QUESTION_MESSAGE);
    		String numeroDePersonas = JOptionPane.showInputDialog (this, "Numero de acompanhantes", "Realizar una reserva", JOptionPane.QUESTION_MESSAGE);
    		String fechaEntrada = JOptionPane.showInputDialog (this, "Fecha de llegada: dd-MM-yyyy", "Realizar una reserva", JOptionPane.QUESTION_MESSAGE);
    		String fechaSalida = JOptionPane.showInputDialog (this, "Fecha de salida: dd-MM-yyyy", "Realizar una reserva", JOptionPane.QUESTION_MESSAGE);

    		Date fechaE=(Date) new SimpleDateFormat("dd-MM-yyyy").parse(fechaEntrada);  
    		Date fechaS=(Date) new SimpleDateFormat("dd-MM-yyyy").parse(fechaSalida);  
    		
    		if (tipoDocumento != null && numeroDocumento != null && numeroHabitacion != null)
    		{
        		VOReserva tb = hotelAndes.realizarUnaReserva(Long.valueOf(tipoDocumento), numeroDocumento, numeroHabitacion
        				,Integer.valueOf(numeroDePersonas),fechaE , fechaS);
        		if (tb == null)
        		{
        			throw new Exception ("No se pudo crear la reserva");
        		}
        		String resultado = "La reserva se realizo correctamente";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }

	/**
	 * Este m�todo ejecuta la aplicaci�n, creando una nueva interfaz
	 * 
	 * @param args Arreglo de argumentos que se recibe por l�nea de comandos
	 */
	public static void main(String[] args) 
	{
		try 
		{

			// Unifica la interfaz para Mac y para Windows.
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			InterfazHotelAndesApp interfaz = new InterfazHotelAndesApp();
			interfaz.setVisible(true);
		} 
		catch (Exception e) {e.printStackTrace();}
	}

}
