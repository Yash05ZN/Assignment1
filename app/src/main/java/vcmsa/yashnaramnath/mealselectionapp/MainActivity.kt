package vcmsa.yashnaramnath.mealselectionapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import vcmsa.yashnaramnath.mealselectionapp.R.id.btnChoices
import vcmsa.yashnaramnath.mealselectionapp.R.id.edtextTimeinput



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //code starts here
        val edtextTimeinput = findViewById<EditText>(R.id.edtextTimeinput) //EditText for input
        val btnChoices = findViewById<Button>(R.id.btnChoices)
        val tvOptions = findViewById<TextView>(R.id.tvOptions)
        val btnReset = findViewById<Button>(R.id.btnReset)

        // AI assisted to fix code
        // Set up the onClickListener for btnChoices
        btnChoices.setOnClickListener {
            // Get the input text from the EditText and convert it to lowercase
            val inputTime = edtextTimeinput.text.toString().trim().lowercase()


            // Initialize meal Suggestion
            var mealSuggestion = ""

            // Use a when statement to check the input and suggest a meal

                when (inputTime.lowercase()) {
                    "morning" -> mealSuggestion = "Eggs and Toast, Cereal, Smoothie"
                    "mid-morning" -> mealSuggestion = "Fruits and Nuts"
                    "afternoon" -> mealSuggestion = "A Salad, A Sandwich"
                    "mid-afternoon" -> mealSuggestion = "Some Dried Fruit, Crackers and Cheese"
                    "dinner" -> mealSuggestion = "Grilled Chicken, Pasta "
                    "after dinner" -> mealSuggestion = "Some Popcorn, Yoghurt"
                    else -> mealSuggestion = "Incorrect time of day"
                }

            // Set the meal suggestion text to tvOptions
            tvOptions.text = mealSuggestion

            // Set up the OnCLickListener for btnReset
            btnReset.setOnClickListener {
                //clear the editText and TextView
                edtextTimeinput.text.clear()  //Clears the Input field
                tvOptions.text = ""           // Clears the meal options display
            }
        }
    }
}