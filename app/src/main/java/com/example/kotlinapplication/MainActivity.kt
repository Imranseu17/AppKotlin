package com.example.kotlinapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val options = arrayOf("option 1","option 2","option 3")

        sp_option.adapter = ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,options)

        button.setOnClickListener {
            button.text = "Clicked"
            textView.text = "The latest developer preview of Android,bringing performance enhancements " +
                    "and new features to your apps"
            textView.setSingleLine()
            textView.ellipsize = TextUtils.TruncateAt.MARQUEE
            textView.marqueeRepeatLimit = -1
            textView.isSelected = true

            startActivity(Intent(this,RecyclerActivity::class.java))
        }

        button.setOnLongClickListener {

            button.text =  "Long Clicked"
            textView.text = "Hello  Imran"
            textView.setSingleLine()
            textView.ellipsize = TextUtils.TruncateAt.MARQUEE
            textView.marqueeRepeatLimit = -1
            textView.isSelected = true
            true
        }

        submit.setOnClickListener {

            var result = ""
            if(rg_gender.checkedRadioButtonId != 1){
                result += "Selected Gender : "
                if(radiobuttonmale.isChecked)
                    result += "male\n"
                else if(radiobuttonfemale.isChecked)
                    result += "female\n"


            }

            result += " Languages Known : "

            if(checkboxenglish.isChecked)
                result += "English and "
            if(checkboxtamil.isChecked)
                result += "Tamil and "
            if(checkboxhindi.isChecked)
                result += "Hindi and "

            anwser.text = result
        }

        btn_copy.setOnClickListener {

            tv_result.text = editText.text
        }

        editText.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                tv_result.text = s
            }

        })

        sp_option.onItemSelectedListener = object : AdapterView.OnItemClickListener,
            AdapterView.OnItemSelectedListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                result.text = options.get(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
               result.text = "Please Select an Option"
            }


        }

        sb_slider.max = 50

        sb_slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
              seekbarResult.text = "Seeking to : "+ progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
               seekbarResult.text = "Started at : "+seekBar.progress
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                      seekbarResult.text = "Selected : "+seekBar.progress
            }

        })



        
    }
}
