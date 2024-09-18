import java.io.File;
import java.io.IOException;

public class arquivos {
    Metodos m;
    public arquivos () {
        m = new Metodos();
    }

    public void ejercicio1() {
        System.out.println("crear o directorio 'arquivosdir' na ruta '/home/postgres/NetBeansProjects/arquivos/' sempre \ne cando dito directorio non exista previamente Comprobar que se trata  dun directorio mediante o metodo eDirectorio que creache anteriormente \n(Comprobar que o directorio foi creado ou existe,  mediante os comandos do sistema operativo (modo texto) , ou mediante o entorno grafico");
        m.creaDirectorio("./arquivosdir");
        System.out.println("Archivo creado!");
    }

    public void ejercicio2() throws IOException {
        System.out.println("crear  o arquivo Products1.txt no directorio mencionado anteriormente (arquivosdir) sempre e cando dito arquivo non exista.Comprobar que se trata  dun ficheiro mediante o metodo eFicheiro que creache anteriormente. (Comprobar que o arquivo foi creado ou existe mediante comandos do sistema operativo (modo texto) ou mediante o entorno grafico.)");
        m.creaFicheiro("./arquivosdir","Products1.txt");
        m.eFicheiro("./arquivosdir/Products1.txt");
    }

    public void ejercicio3() throws IOException {
        System.out.println("Crear o directorio 'subdir'  na ruta '/home/postgres/NetBeansProjects/arquivos/arquivosdir/' creada anteriormente\n" + "Crear o arquivo Products2.txt no directorio mencionado anteriormente (subdir)");
        m.creaDirectorio("./arquivosdir/subdir");
        m.creaFicheiro("./arquivosdir/subdir","Products2.txt");
    }

    public void ejercicio4() {
        System.out.println("4)Amosar arquivos e subdirectorios de primeiro nivel da ruta  '/home/postgres/NetBeansProjects/arquivos/arquivosdir/'\n" +
                "Debería amosarse o seguinte resultado:\n" +
                "\n" +
                "\t\tProducts1.txt\n" +
                "\t\tsubdir");
        m.mContido("./arquivosdir");
    }

    public void ejercicio5() throws IOException {
        System.out.println("amosar a seguinte informacion sobre o primeiro  arquivo (Products1.txt) creado:\n" +
                "\t si e posible ou non escribir nel\n" +
                "\t si e posible ou non ler del\n" +
                "\t a sua lonxitude en bytes \n" +
                "\t (a continuacion debes editar manualmente  o arquivo co editor de texto e escribir un texto calquera, por exemplo a palabra  'ola', e volver a amosar a sua lonxitude en bytes (deberia ter cambiado))");
        m.modoAcceso("./arquivosdir","Products1.txt");
        m.borraFicheiro("./arquivosdir","Products1.txt");
        m.calculaLonxitude("./arquivosdir","Products1.txt");
        System.out.println("Ahora escribo sobre el archivo: 'Hola'");
        m.writeFile("Hola");
        m.calculaLonxitude("./arquivosdir","Products1.txt");
    }

    public void ejercicio6(){
        System.out.println("Forzar a que o mesmo arquivo referido no apartado anterior   sexa de so lectura\n" +
                "(comprobar intentanto editar o arquivo manualmente  que no se pode escribir nada en dito arquivo)");
        m.mLectura("./arquivosdir","Products1.txt");
        m.modoAcceso("./arquivosdir","Products1.txt");
    }

    public void ejercicio7(){
        System.out.println("forzar a que o arquivo referido no apartado anterior pase de novo a ser de novo de  escritura\n" +
                "(comprobar dendo o sistema operativo que se pode escribir de novo no  arquivo)");
        m.mEscritura("./arquivosdir","Products1.txt");
        m.modoAcceso("./arquivosdir","Products1.txt");
    }

    public void ejercicio8(){
        System.out.println("borrar o arquivo referido no apartado anterior\n" +
                "(comprobar manualmente dende o sistema operativo que o arquivo foi borrado)");
        m.borraFicheiro("./arquivosdir","Products1.txt");
        m.mContido("./arquivosdir");
    }

    public void ejercicio9(){
        System.out.println("borrar os o resto de arquivos e directorios creados anteriormente ");
        m.borrarFile(m.mContido2("./arquivosdir"));
    }

    public void ejercicio10(){
        System.out.println("(opcional) amosa usando o metodo recur(File) todos  os subdirectorios e arquivos que colgan do directorio '/home/postgres/NetBeansProjects/arquivos/arquivosdir/'");
        m.recur(new File("./arquivosdir"));
    }
}
