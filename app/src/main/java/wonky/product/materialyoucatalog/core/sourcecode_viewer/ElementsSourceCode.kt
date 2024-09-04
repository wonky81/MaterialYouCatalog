package wonky.product.materialyoucatalog.core.sourcecode_viewer

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

val functionColor =Color(0xFF56A8F5)
val parameterColor = Color(0xFF16BAAC)
val valueColor = Color(0xFFCF8E6D)



@Composable
fun colorize(codeText: String, regexColorList: List<Pair<String,Color>>): AnnotatedString = buildAnnotatedString {
    val indexMap: MutableMap<Int,Pair<Int,Color>> = mutableMapOf()
    regexColorList.forEach {
        val regex = Regex(it.first)
        val matchResult = regex.findAll(codeText)
        for(matchItem in matchResult){
            indexMap[matchItem.range.first] = Pair(matchItem.range.last,it.second)
        }
    }

    var codeIndex = 0
    while (codeIndex < codeText.length) {
        if (indexMap[codeIndex] != null) {
            val colorStringBuilder = StringBuilder()
            for (i in codeIndex..indexMap[codeIndex]!!.first) {
                colorStringBuilder.append(codeText[i])
            }
            withStyle(
                style = SpanStyle(
                    color = indexMap[codeIndex]!!.second,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append(colorStringBuilder.toString())
            }
            codeIndex = indexMap[codeIndex]!!.first.plus(1)
        } else {
            append(codeText[codeIndex])
            codeIndex++
        }
    }
}