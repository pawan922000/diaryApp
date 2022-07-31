package com.example.diaryapp.ui.fragments
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Html
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.*

import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.core.text.getSpans
import androidx.core.text.toHtml
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.diaryapp.R
import com.example.diaryapp.databinding.FragmentEditfragmentBinding

import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import roommvvm.ViewModel.NotesViewModel
import roommvvm.model.Notes
import java.text.SimpleDateFormat
import java.util.*


class EditFragment : Fragment() {
    val oldnotes by navArgs<EditFragmentArgs>()
    lateinit var binding: FragmentEditfragmentBinding
    val viewModel: NotesViewModel by viewModels()
    var flag= "0"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentEditfragmentBinding.inflate(layoutInflater,container,false)
        setHasOptionsMenu(true)
        val span1 = Html.fromHtml(oldnotes.data.title,63)
        val span2 = Html.fromHtml(oldnotes.data.notes,63)
        binding.editTitle.setText(span1)
        binding.editNotes.setText(span2)
// background color change before settings
        when(oldnotes.data.flag){
            "1" -> {
                flag="1"
                binding.editNotes.setBackgroundResource(R.color.purple_200)
                binding.editTitle.setBackgroundResource(R.color.purple_200)
                binding.dateButton.setBackgroundResource(R.color.purple_200)
            }
            "2" -> {
                flag="2"
                binding.editNotes.setBackgroundResource(R.color.white)
                binding.editTitle.setBackgroundResource(R.color.white)
                binding.dateButton.setBackgroundResource(R.color.white)
            }
            "3" -> {
                flag="3"
                binding.editNotes.setBackgroundResource(R.color.pink)
                binding.editTitle.setBackgroundResource(R.color.pink)
                binding.dateButton.setBackgroundResource(R.color.pink)
            }
            "4" -> {
                flag="4"
                binding.editNotes.setBackgroundResource(R.color.seagreen)
                binding.editTitle.setBackgroundResource(R.color.seagreen)
                binding.dateButton.setBackgroundResource(R.color.seagreen)
            }
            "5" -> {
                flag="5"
                binding.editNotes.setBackgroundResource(R.color.yellow)
                binding.editTitle.setBackgroundResource(R.color.yellow)
                binding.dateButton.setBackgroundResource(R.color.yellow)
            }
        }
//background color change after settings
        binding.colorButton.setOnClickListener {
            layoutInflater.inflate(R.layout.background_colour, null)
            val bottomSheet = BottomSheetDialog(requireContext())
            bottomSheet.setContentView(R.layout.background_colour)
            val purple = bottomSheet.findViewById<FloatingActionButton>(R.id.purple)
            val white = bottomSheet.findViewById<FloatingActionButton>(R.id.white)
            val pink = bottomSheet.findViewById<FloatingActionButton>(R.id.pink)
            val green = bottomSheet.findViewById<FloatingActionButton>(R.id.green)
            val yellow = bottomSheet.findViewById<FloatingActionButton>(R.id.yellow)
            purple?.setOnClickListener {
                flag = "1"
                binding.editNotes.setBackgroundResource(R.color.purple_200)
                binding.editTitle.setBackgroundResource(R.color.purple_200)
                binding.dateButton.setBackgroundResource(R.color.purple_200)
                bottomSheet.dismiss()
            }
            white?.setOnClickListener {
                flag = "2"
                binding.editNotes.setBackgroundResource(R.color.white)
                binding.editTitle.setBackgroundResource(R.color.white)
                binding.dateButton.setBackgroundResource(R.color.white)
                bottomSheet.dismiss()
            }
            pink?.setOnClickListener {
                flag = "3"
                binding.editNotes.setBackgroundResource(R.color.pink)
                binding.editTitle.setBackgroundResource(R.color.pink)
                binding.dateButton.setBackgroundResource(R.color.pink)
                bottomSheet.dismiss()
            }
            green?.setOnClickListener {
                flag = "4"
                binding.editNotes.setBackgroundResource(R.color.seagreen)
                binding.editTitle.setBackgroundResource(R.color.seagreen)
                binding.dateButton.setBackgroundResource(R.color.seagreen)
                bottomSheet.dismiss()
            }
            yellow?.setOnClickListener {
                flag = "5"
                binding.editNotes.setBackgroundResource(R.color.yellow)
                binding.editTitle.setBackgroundResource(R.color.yellow)
                binding.dateButton.setBackgroundResource(R.color.yellow)
                bottomSheet.dismiss()
            }
            bottomSheet.show()
        }
        //bold
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

        binding.btnEditSaveNotes.setOnClickListener {
            updateNotes(it)
        }
        return binding.root
    }

    private fun updateNotes(it: View?) {
        val title=binding.editTitle.text.toHtml(1).replace("<p dir=\"ltr\">", "").replace(
            "<p dir=\"rtl\">", "").replace("<p>","").replace("</p>","").trim()
        val notes=binding.editNotes.text.toHtml(1).replace("<p dir=\"ltr\">", "").replace(
            "<p dir=\"rtl\">", "").replace("<p>","").replace("</p>","").trim()


        val dateNow = Calendar.getInstance().time
        val formatter = SimpleDateFormat.getDateTimeInstance() //or use getDateInstance()
        val date = formatter.format(dateNow)
        val data = Notes(oldnotes.data.id, flag , title=title,notes=notes,date=date.toString())
        viewModel.updateNotes(data)

        Toast.makeText(requireContext(),"your page updated successfully",
            Toast.LENGTH_SHORT).show()
        Navigation.findNavController(it!!).navigate(R.id.action_editfragment2_to_homefragment)

    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.del_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_del)
        {

            val bottomSheet: BottomSheetDialog = BottomSheetDialog(requireContext())
            bottomSheet.setContentView(R.layout.dialogue)

            val textviewyes= bottomSheet.findViewById<TextView>(R.id.dialog_yes)
            val textviewno= bottomSheet.findViewById<TextView>(R.id.dialog_no)

            textviewyes?.setOnClickListener {
                viewModel.deleteNotes(oldnotes.data.id!!)
                bottomSheet.dismiss()
                findNavController().navigate(R.id.action_editfragment2_to_homefragment)
            }
            textviewno?.setOnClickListener {
                bottomSheet.dismiss()
            }
            bottomSheet.show()
        }
        return super.onOptionsItemSelected(item)
    }
}