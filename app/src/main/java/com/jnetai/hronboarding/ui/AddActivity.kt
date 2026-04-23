package com.jnetai.hronboarding.ui

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.jnetai.hronboarding.HROnboardingApp
import com.jnetai.hronboarding.databinding.ActivityAddItemBinding
import com.jnetai.hronboarding.model.Employee
import com.jnetai.hronboarding.model.OnboardStatus
import com.jnetai.hronboarding.model.Dept
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddItemBinding
    private val app get() = application as HROnboardingApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Add Employee"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.typeSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, Dept.values().map { it.label })
        binding.statusSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, OnboardStatus.values().map { it.label })

        binding.saveButton.setOnClickListener {
            val name = binding.titleEdit.text?.toString()?.trim() ?: ""
            if (name.isBlank()) { Toast.makeText(this, "Name required", Toast.LENGTH_SHORT).show(); return@setOnClickListener }
            lifecycleScope.launch {
                app.database.dao().insert(Employee(
                    name = name,
                    department = Dept.values()[binding.typeSpinner.selectedItemPosition],
                    onboardingStatus = OnboardStatus.values()[binding.statusSpinner.selectedItemPosition],
                    notes = binding.notesEdit.text?.toString()?.trim() ?: ""
                ))
                finish()
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean { finish(); return true }
}
