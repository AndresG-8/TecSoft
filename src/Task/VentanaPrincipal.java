package Task;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
//import javax.swing.JFrame;
import static javax.swing.JFrame.DISPOSE_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Gomez
 */
public class VentanaPrincipal extends javax.swing.JDialog implements ActionListener{
    private JPanel pOpciones;
    private JButton btnAdel,btnAtras,btnAumentar,btnDisminuir,btnImprimir;
    private File archivo;//la declaracion del archivo que se quiere, usada en el filechooser
    private CuadroImagen img;//clase CuadroImagen
    private JScrollPane scroll;
    private String imagenes[];//un array donde se almacenan la lista de archivos en el directorio
    private ArrayList ListaImagenes;//guardamos TODAS las imagenes del directorio
    private String path;//el parent del directorio al pulsar abrir.
    private int numImg;//determina la cantidad de imagenes en el directorio
    
     String padre, ruta;
    public VentanaPrincipal(javax.swing.JDialog parent, Boolean modal, String padre, String ruta){
        super(parent, modal);
        this.padre = padre;
        this.ruta = ruta;
        initComponents();
        
    }
 
 //metodo de ActionListener
 
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnAdel){
            numImg++;
            if(numImg>=ListaImagenes.size())numImg=0;
            img.setImagen(path+"/"+ListaImagenes.get(numImg));
        }else if(e.getSource()==btnAtras){
            numImg--;
            if(numImg<0)numImg=ListaImagenes.size() - 1;
            img.setImagen(path+"/"+ListaImagenes.get(numImg));
        }else if(e.getSource()==btnAumentar){
            img.aumentar();
        }else if(e.getSource()==btnDisminuir){
            img.disminuir();
        }else if(e.getSource()==btnImprimir){
            img.imprimir();
        }
    }

//funciones getter y setter
    public File getArchivo() {
        return archivo;
    }


    public void setArchivo(File archivo) {
        this.archivo = archivo;
    } 
 
    //Comprueba que solo cargue las imagenes
    public boolean esImagen(String dirImg){
        if(dirImg.lastIndexOf(".jpg")>0||dirImg.lastIndexOf(".png")>0||dirImg.lastIndexOf(".gif")>0||dirImg.lastIndexOf(".jpeg")>0){
            return true;
        }
        return false;
    }

    private void initComponents() {
         //LO NATIVO DEL CONSTRUCTOR
        setSize(800,600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        numImg = 0;
        img = new CuadroImagen();
        scroll = new JScrollPane(img,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.add(scroll,BorderLayout.CENTER);
        pOpciones = new JPanel();
        btnAdel = new JButton();
        //agregado desde la v6 un icono que represente la accion
        btnAdel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/resultset_next.png")));
        btnAtras = new JButton();
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/resultset_previous.png")));
        btnAumentar = new JButton();
        btnAumentar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/magnifier_zoom_in.png")));
        btnDisminuir = new JButton();
        btnDisminuir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/magnifier_zoom_out.png")));
        btnImprimir = new JButton("Imprimir");
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/printer.png")));
        pOpciones.add(btnAtras);
        pOpciones.add(btnAdel);
        pOpciones.add(btnAumentar);
        pOpciones.add(btnDisminuir);
        pOpciones.add(btnImprimir);
        this.add(pOpciones,BorderLayout.SOUTH);
            //listeners
        btnAtras.addActionListener(this);
        btnAdel.addActionListener(this);
        btnAumentar.addActionListener(this);
        btnDisminuir.addActionListener(this);
        btnImprimir.addActionListener(this);
        setLocationRelativeTo(null);
        //setVisible(true);
        
        File dir = new File(ruta);
        archivo = dir;//coge el archivo seleccionado
        imagenes = archivo.getParentFile().list();//guarda todos sus hermanos
        ListaImagenes = new ArrayList<String>();//isntancia el arraylist
        //este for recorre los objetos existentes en el array de imagenes
        //sin necesidad de decir cuantos  son
        //define el tipo de elemento, y la coleccion a recorrer
        for(String img:imagenes){
            //este metodo se puede evitar usando el filttro al JFileChooser
            if(this.esImagen(img)){//si es imagen. que lo agregue al araylist
                ListaImagenes.add(img);//Agrega las imagenes al 
            }
        }
        path = archivo.getParent();//definimos el padre
        //llamamos a la clase CuadroImagen para establecer la imagen
        img.setImagen(archivo.getAbsoluteFile().toString());
        //setVisible(true);
    }
 
}
