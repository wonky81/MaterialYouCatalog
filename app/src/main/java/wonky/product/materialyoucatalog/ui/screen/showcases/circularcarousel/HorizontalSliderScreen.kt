package wonky.product.materialyoucatalog.ui.screen.showcases.circularcarousel

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp

private const val TAG = "HorizontalSliderScreen"

@Composable
fun HorizontalSliderScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        HorizontalSlider(
            items = arrayListOf(0,1,2,/*3,4,5,6,7,8,9*/),
        ){
            Surface(
                modifier = Modifier.fillMaxHeight().width(80.dp),
                color = androidx.compose.ui.graphics.Color.Blue
            ){

            }
            Text(it.toString())
        }
    }

}

@Composable
fun HorizontalSlider(
    items: List<Int>,
    modifier: Modifier = Modifier,
    content: @Composable (Int) -> Unit,
){
    Log.d(TAG, "HorizontalSlider: Item Size = ${items.size}")
    Layout(
        modifier = modifier,
        content = {
            repeat(items.size){
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    content(it)
                }
            }
        }
    ){ measureables, constraints ->
        Log.d(TAG, "HorizontalSlider: width = ${constraints.maxWidth}, height = ${constraints.maxHeight}")
        val itemWidthDimension = constraints.maxWidth/3-40
        val itemHeightDimension = constraints.maxHeight-160
        val itemConstraints = Constraints.fixed(
            width = itemWidthDimension,
            height = itemHeightDimension
        )

        val placeables = measureables.map {  measurable ->
            measurable.measure(itemConstraints)
        }

        layout(
            width = constraints.maxWidth,
            height = constraints.maxHeight
        ){
            Log.d(TAG, "HorizontalSlider: size = ${placeables.size}")
            placeables.forEachIndexed { index, placeable ->
                Log.d(TAG, "HorizontalSlider: index = $index")
                placeable.placeRelative(
                    x = index*itemWidthDimension,
                    y = 0
                )
            }
        }

    }
}