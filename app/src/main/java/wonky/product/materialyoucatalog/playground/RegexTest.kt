package wonky.product.materialyoucatalog.playground

fun main(){
    val codeSnippet = """
    ElevatedButton( 
        enabled = {elevatedButtonEnabled} , 
        elevation = ButtonDefaults.elevatedButtonElevation( 
            defaultElevation =  {elevatedButtonDefaultElevation} . dp, 
            disabledElevation = {elevatedButtonDisabledElevation} . dp 
        ) 
    )
""".trimIndent()

    val functionNameRegex = Regex("""(\w+)\s*\(""")
    val matchResult = functionNameRegex.find(codeSnippet)
    val functionName = matchResult?.groupValues?.getOrNull(1)

    if (matchResult != null) {
        println("start: "+(matchResult.range.first)+", end: "+(matchResult.range.last-1)+"")
        println(codeSnippet.substring(matchResult.range.first+4,matchResult.range.last))
    } // Output:
}