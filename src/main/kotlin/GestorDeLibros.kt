
import java.util.logging.Level
import java.util.logging.LogManager

internal val l = LogManager.getLogManager().getLogger("").apply { level = Level.ALL }
internal fun i(tag: String, msg: String) {
    l.info("[$tag] - $msg")
}


fun main() {
    var portatil = "/home/edu/IdeaProjects/IESRA-DAM-Prog/ejercicios/src/main/kotlin/un5/eje5_4/Catalog.xml"
    //var casa = "/home/usuario/Documentos/workspace/IdeaProjects/IESRA-DAM/ejercicios/src/main/kotlin/un5/eje5_4/Catalog.xml"

    val gestorDeLibros = gestionLibros(portatil)
    gestorDeLibros.preguntarPorUnLibro()
    gestorDeLibros.mostrarInfoDeUnLibro()

}

// con la interface abstraigo la consulta al archivo aunque no consigo hacerlo bien del todo
 interface Gestiondelibros {

      open var cat : CatalogolibrosXML

 }
// Pretendo sacar los datos que piden por pantalla a clases externas lo que no se es si hacerlas abstractas o simples clases para comunicarlas
  open class gestionLibros(cargador:String):Gestiondelibros {
      override var cat = CatalogolibrosXML(cargador)

      fun preguntarPorUnLibro() : gestionLibrosIUT1 {
        return  gestionLibrosIUT1(cat).Preguntaporunlibro()
      }

      fun mostrarInfoDeUnLibro() {
          println("Introduzca un ID: ")
          var idLibro = readln()
          var infoLibro = cat.infoLibro(idLibro)
          if (!infoLibro.isEmpty())
              println("La información sobre es la siguiente\n$infoLibro")
          else
              println("No se encontró información sobre el libro")
      }
  }
//Esta es la clase con la que controlo los datos pedidos y los devuelvo en strings.
     class gestionLibrosIUT1(override var cat: CatalogolibrosXML) : Gestiondelibros  {
        var a = Preguntaporunlibro()
        var b = Monstrarinfodeunlibro()
        fun Preguntaporunlibro(): String {
            println("Introduzca un ID: ")
            var idLibro = readln()
            if (cat.existeLibro(idLibro))
                 return "El libro $idLibro existe!"
            else
                return "El libro $idLibro NO existe!"

        }
        fun Monstrarinfodeunlibro() : String {
            println("Introduzca un ID: ")
            var idLibro = readln()
            var infoLibro = cat.infoLibro(idLibro)
            if (!infoLibro.isEmpty())
                return "La información sobre es la siguiente\n$infoLibro"
            else
            return "No se encontró información sobre el libro"
        }

    }
