package com.example.diaryapp.ui.fragments

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.*
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.text.getSpans
import androidx.core.text.toHtml
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.room.util.StringUtil
import com.example.diaryapp.R
import com.example.diaryapp.databinding.FragmentCreateNotesBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import roommvvm.ViewModel.NotesViewModel
import roommvvm.model.Notes
import java.text.SimpleDateFormat

import java.util.*

class CreateNotesFragment : Fragment() {

    lateinit var binding: FragmentCreateNotesBinding
    val viewModel: NotesViewModel by viewModels()
    var flag= "0"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentCreateNotesBinding.inflate(layoutInflater,container,false)
        binding.BtnSaveNotes.setOnClickListener {
            createNotes(it)
        }
        binding.colorButton.setOnClickListener {
            layoutInflater.inflate(R.layout.background_colour,null)
            val bottomSheet= BottomSheetDialog(requireContext())
            bottomSheet.setContentView(R.layout.background_colour)
            val purple=bottomSheet.findViewById<FloatingActionButton>(R.id.purple)
            val white=bottomSheet.findViewById<FloatingActionButton>(R.id.white)
            val pink=bottomSheet.findViewById<FloatingActionButton>(R.id.pink)
            val green=bottomSheet.findViewById<FloatingActionButton>(R.id.green)
            val yellow=bottomSheet.findViewById<FloatingActionButton>(R.id.yellow)
            purple?.setOnClickListener {
                flag= "1"
                binding.editNotes.setBackgroundResource(R.color.purple_200)
                binding.editTitle.setBackgroundResource(R.color.purple_200)
                binding.dateButton.setBackgroundResource(R.color.purple_200)
                bottomSheet.dismiss()
            }
            white?.setOnClickListener {
                flag= "2"
                binding.editNotes.setBackgroundResource(R.color.white)
                binding.editTitle.setBackgroundResource(R.color.white)
                binding.dateButton.setBackgroundResource(R.color.white)
                bottomSheet.dismiss()
            }
            pink?.setOnClickListener {
                flag= "3"
                binding.editNotes.setBackgroundResource(R.color.pink)
                binding.editTitle.setBackgroundResource(R.color.pink)
                binding.dateButton.setBackgroundResource(R.color.pink)
                bottomSheet.dismiss()
            }
            green?.setOnClickListener {
                flag= "4"
                binding.editNotes.setBackgroundResource(R.color.seagreen)
                binding.editTitle.setBackgroundResource(R.color.seagreen)
                binding.dateButton.setBackgroundResource(R.color.seagreen)
                bottomSheet.dismiss()
            }
            yellow?.setOnClickListener {
                flag= "5"
                binding.editNotes.setBackgroundResource(R.color.yellow)
                binding.editTitle.setBackgroundResource(R.color.yellow)
                binding.dateButton.setBackgroundResource(R.color.yellow)
                bottomSheet.dismiss()
            }
            bottomSheet.show()
        }
        binding.bold.setOnClickListener {
                val SpannableString = SpannableStringBuilder(binding.editNotes.text)
                SpannableString.setSpan(
                    StyleSpan(Typeface.BOLD), binding.editNotes.selectionStart,
                    binding.editNotes.selectionEnd, 0)
                binding.editNotes.text = SpannableString
            }
        binding.italic.setOnClickListener {
            val SpannableString= SpannableStringBuilder(binding.editNotes.text)
           // val SpannableString2= SpannableStringBuilder(binding.editTitle.text)
            val styleSpan= StyleSpan(Typeface.ITALIC)
            SpannableString.setSpan(styleSpan,binding.editNotes.selectionStart,
                binding.editNotes.selectionEnd,0)
            //SpannableString2.setSpan(styleSpan,binding.editTitle.selectionStart, binding.editTitle.selectionEnd,0)
            binding.editNotes.text=SpannableString
        //    binding.editTitle.text=SpannableString2
        }
        binding.pencolor.setOnClickListener {
            layoutInflater.inflate(R.layout.pen_color,null)
            val bottomSheet= BottomSheetDialog(requireContext())
            bottomSheet.setContentView(R.layout.pen_color)
            val black=bottomSheet.findViewById<FloatingActionButton>(R.id.blackpen)
            val red=bottomSheet.findViewById<FloatingActionButton>(R.id.redpen)
            val purple=bottomSheet.findViewById<FloatingActionButton>(R.id.purplepen)
            val green=bottomSheet.findViewById<FloatingActionButton>(R.id.greenpen)
            val blue=bottomSheet.findViewById<FloatingActionButton>(R.id.bluepen)

            red?.setOnClickListener {
                val SpannableString = SpannableStringBuilder(binding.editNotes.text)
                val SpannableString2 = SpannableStringBuilder(binding.editTitle.text)
                val styleSpan = ForegroundColorSpan(Color.RED)
                SpannableString.setSpan(
                    styleSpan, 0, binding.editNotes.length(), 0)
                SpannableString2.setSpan(
                    styleSpan, 0, binding.editTitle.length(), 0)
                binding.editNotes.text = SpannableString
                binding.editTitle.text = SpannableString2
                bottomSheet.dismiss()
            }
            black?.setOnClickListener {
                val SpannableString = SpannableStringBuilder(binding.editNotes.text)
                val SpannableString2 = SpannableStringBuilder(binding.editTitle.text)
                val styleSpan = ForegroundColorSpan(Color.BLACK)
                SpannableString.setSpan(styleSpan, 0, binding.editNotes.length(), 0)
                SpannableString2.setSpan(styleSpan, 0, binding.editTitle.length(), 0)
                binding.editNotes.text = SpannableString
                binding.editTitle.text = SpannableString2
                bottomSheet.dismiss()
            }
            purple?.setOnClickListener {
                val SpannableString = SpannableStringBuilder(binding.editNotes.text)
                val SpannableString2 = SpannableStringBuilder(binding.editTitle.text)
                val styleSpan = ForegroundColorSpan(Color.MAGENTA)
                SpannableString.setSpan( styleSpan, 0, binding.editNotes.length(), 0)
                SpannableString2.setSpan( styleSpan, 0, binding.editTitle.length(), 0)
                binding.editNotes.text = SpannableString
                binding.editTitle.text = SpannableString2
                bottomSheet.dismiss()
            }
            green?.setOnClickListener {
                val SpannableString = SpannableStringBuilder(binding.editNotes.text)
                val SpannableString2 = SpannableStringBuilder(binding.editTitle.text)
                val styleSpan = ForegroundColorSpan(Color.GREEN)
                SpannableString.setSpan( styleSpan, 0, binding.editNotes.length(), 0)
                SpannableString2.setSpan( styleSpan, 0, binding.editTitle.length(), 0)
                binding.editNotes.text = SpannableString
                binding.editTitle.text = SpannableString2
                bottomSheet.dismiss()
            }
            blue?.setOnClickListener {
                val SpannableString = SpannableStringBuilder(binding.editNotes.text)
                val SpannableString2 = SpannableStringBuilder(binding.editTitle.text)
                val styleSpan = ForegroundColorSpan(Color.BLUE)
                SpannableString.setSpan( styleSpan, 0, binding.editNotes.length(), 0)
                SpannableString2.setSpan( styleSpan, 0, binding.editTitle.length(), 0)
                binding.editNotes.text = SpannableString
                binding.editTitle.text = SpannableString2
                bottomSheet.dismiss()
            }
            bottomSheet.show()
        }
        binding.underline.setOnClickListener {
            val SpannableString= SpannableStringBuilder(binding.editNotes.text)
            //val SpannableString2= SpannableStringBuilder(binding.editTitle.text)
            val styleSpan= UnderlineSpan()
            SpannableString.setSpan(styleSpan,binding.editNotes.selectionStart,
                binding.editNotes.selectionEnd,0)
//            SpannableString2.setSpan(styleSpan,binding.editTitle.selectionStart,
//                binding.editTitle.selectionEnd,0)
            binding.editNotes.text=SpannableString
           // binding.editTitle.text=SpannableString2
        }
        binding.highlighter.setOnClickListener {
            layoutInflater.inflate(R.layout.pen_color,null)
            val bottomSheet= BottomSheetDialog(requireContext())
            bottomSheet.setContentView(R.layout.pen_color)
            val black=bottomSheet.findViewById<FloatingActionButton>(R.id.blackpen)
            val red=bottomSheet.findViewById<FloatingActionButton>(R.id.redpen)
            val purple=bottomSheet.findViewById<FloatingActionButton>(R.id.purplepen)
            val green=bottomSheet.findViewById<FloatingActionButton>(R.id.greenpen)
            val blue=bottomSheet.findViewById<FloatingActionButton>(R.id.bluepen)

            red?.setOnClickListener {
                val SpannableString = SpannableStringBuilder(binding.editNotes.text)

                val styleSpan = BackgroundColorSpan(Color.RED)
                SpannableString.setSpan(
                    styleSpan, binding.editNotes.selectionStart,
                    binding.editNotes.selectionEnd, 0)
                binding.editNotes.text = SpannableString
                bottomSheet.dismiss()
            }
            black?.setOnClickListener {
                val SpannableString = SpannableStringBuilder(binding.editNotes.text)
                val styleSpan = BackgroundColorSpan(Color.BLACK)
                SpannableString.setSpan(
                    styleSpan, binding.editNotes.selectionStart,
                    binding.editNotes.selectionEnd, 0)
                binding.editNotes.text = SpannableString
                bottomSheet.dismiss()
            }
            purple?.setOnClickListener {
                val SpannableString = SpannableStringBuilder(binding.editNotes.text)
                val styleSpan = BackgroundColorSpan(Color.MAGENTA)
                SpannableString.setSpan(
                    styleSpan, binding.editNotes.selectionStart,
                    binding.editNotes.selectionEnd, 0)
                binding.editNotes.text = SpannableString
                bottomSheet.dismiss()
            }
            green?.setOnClickListener {
                val SpannableString = SpannableStringBuilder(binding.editNotes.text)
                val styleSpan = BackgroundColorSpan(Color.GREEN)
                SpannableString.setSpan(
                    styleSpan, binding.editNotes.selectionStart,
                    binding.editNotes.selectionEnd, 0)
                binding.editNotes.text = SpannableString
                bottomSheet.dismiss()
            }
            blue?.setOnClickListener {
                val SpannableString = SpannableStringBuilder(binding.editNotes.text)
                val styleSpan = BackgroundColorSpan(Color.BLUE)
                SpannableString.setSpan(
                    styleSpan, binding.editNotes.selectionStart,
                    binding.editNotes.selectionEnd, 0)
                binding.editNotes.text = SpannableString
                bottomSheet.dismiss()
            }
            bottomSheet.show()
        }
        binding.normalfont.setOnClickListener {
            val SpannableString= SpannableString(binding.editNotes.text)
            val span= SpannableString.getSpans<StyleSpan>(binding.editNotes.selectionStart,
                binding.editNotes.selectionEnd)
            val span3= SpannableString.getSpans<RelativeSizeSpan>(binding.editNotes.selectionStart,
                binding.editNotes.selectionEnd)
            val span7= SpannableString.getSpans<BackgroundColorSpan>(binding.editNotes.selectionStart,
                binding.editNotes.selectionEnd)
            val span9= SpannableString.getSpans<UnderlineSpan>(binding.editNotes.selectionStart,
                binding.editNotes.selectionEnd)
            for (styleSpan in span)SpannableString.removeSpan(styleSpan)
            for (styleSpan in span3)SpannableString.removeSpan(styleSpan)
            for (styleSpan in span7)SpannableString.removeSpan(styleSpan)
            for (styleSpan in span9)SpannableString.removeSpan(styleSpan)
            binding.editNotes.setText(SpannableString)
        }
        binding.size.setOnClickListener {
            val SpannableString= SpannableStringBuilder(binding.editNotes.text)
            val styleSpan= RelativeSizeSpan(1.5f)
            SpannableString.setSpan(styleSpan,binding.editNotes.selectionStart,
                binding.editNotes.selectionEnd,0)
            binding.editNotes.text=SpannableString
        }


        return binding.root
    }
    private fun createNotes(it: View?){
        val title=binding.editTitle.text.toHtml(1).replace("<p dir=\"ltr\">", "").replace(
            "<p dir=\"rtl\">", "").replace("<p>","").replace("</p>","")
        val notes=binding.editNotes.text.toHtml(1).replace("<p dir=\"ltr\">", "").replace(
            "<p dir=\"rtl\">", "").replace("<p>","").replace("</p>","").trim()

        val dateNow = Calendar.getInstance().time
        val formatter = SimpleDateFormat.getDateTimeInstance() //or use getDateInstance()
        val date = formatter.format(dateNow)

        val data = Notes(null,flag,title=title,notes=notes,date=date.toString())
        viewModel.addNotes(data)

        Toast.makeText(requireContext(),"your page added successfully",
            Toast.LENGTH_SHORT).show()
        Navigation.findNavController(it!!).navigate(R.id.action_createNotesfragment_to_Homefragment)
    }

}
