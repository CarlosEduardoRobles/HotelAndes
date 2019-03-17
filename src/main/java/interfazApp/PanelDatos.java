package interfazApp;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelDatos extends JPanel
{
	//------------------------------------------------
	//--------------------Atributos-------------------
    //------------------------------------------------
	/**
	 * Area de texto con barras de deslizamiento
	 */
	private JTextArea textArea;
	
	//------------------------------------------------
	//------------------Constructores-----------------
	//------------------------------------------------
	/**
	 * Construccion del panel
	 */
	public PanelDatos ()
    {
        setBorder (new TitledBorder ("Panel de informacion"));
        setLayout( new BorderLayout( ) );
        
        textArea = new JTextArea("Aqui sale el resultado de las operaciones solicitadas");
        textArea.setEditable(false);
        add (new JScrollPane(textArea), BorderLayout.CENTER);
    }
	
	//------------------------------------------------
	//----------------------Metodos-------------------
	//------------------------------------------------
	/**
     * Actualiza el panel con la informacian recibida por parametro
     * @param texto - El texto con el que actualiza el area
     */
    public void actualizarInterfaz (String texto)
    {
    	textArea.setText(texto);
    }
}
