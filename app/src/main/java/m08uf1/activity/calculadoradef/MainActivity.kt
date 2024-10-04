package m08uf1.activity.calculadoradef

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var inprocessnumber = ""
    private var operator1: Int? = null
    private var operator2 = 0
    private var operator: String? = null
    private lateinit var resultView: TextView
    private lateinit var operationsView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        resultView = findViewById(R.id.Resultat)
        operationsView = findViewById(R.id.Operacions)
        operationsView.text = ""
        resultView.text = ""
        }
    fun calculatorClick(b: View){
        var bstr = b.tag.toString()
        if 
        if(bstr.toIntOrNull() != null){
            addNumber(bstr)
            return}

        if(bstr == "ac"){
            resetCalculator()
            return
        }
        if (bstr == "equal"){
            getResult()
            return
            }

        else{
            setOperator(bstr)
            return
        }
    }
    private fun updateDisplay(){
        operationsView.text = "${operator1 ?: "" } ${operator ?: ""} $inprocessnumber"
    }
    private fun getResult(){
        operator2 = inprocessnumber.toInt()
        resultView.text = when(operator){
            "+" -> (operator1?.plus(operator2)).toString()
            "-" -> (operator1?.minus(operator2)).toString()
            "x" -> (operator1?.times(operator2)).toString()
            "/" -> {
                if (operator2 != 0) {
                    (operator1?.div(operator2)).toString()
                }
                else{
                    "Syntax Error"
                }
            }
            else -> ""
        }
        operator = null
        if(resultView.text.toString().toIntOrNull() != null){
            inprocessnumber = resultView.text.toString()}
        updateDisplay()
    }
    private fun addNumber(bstr: String){
        inprocessnumber += bstr
        updateDisplay()

    }
    private fun setOperator(bstr: String){
        operator1 = inprocessnumber.toInt()
        inprocessnumber = ""
        operator = bstr
        updateDisplay()
    }
    private fun resetCalculator(){
        inprocessnumber = ""
        operator1 = 0
        operator2 = 0
        operator = null
        operationsView.text = ""
        resultView.text = ""
        updateDisplay()
    }
}
