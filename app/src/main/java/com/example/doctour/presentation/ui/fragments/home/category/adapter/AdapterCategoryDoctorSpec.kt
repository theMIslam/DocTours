package com.example.doctour.presentation.ui.fragments.home.category.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.databinding.ItemCategoryDoctorsBinding

class AdapterCategoryDoctorSpec :RecyclerView.Adapter<AdapterCategoryDoctorSpec.ViewHolderCategoryDoctor>(){

    private var list = arrayListOf("Акушер","Аллерголог","Андролог", "Анестезиолог","Анестезиолог-реаниматолог", "Артролог",
        "Вегетолог","Венеролог","Врач ЛФК","Врач МРТ","Врач скорой помощи","Врач функциональной диагностики",
        "Гастроэнтеролог","Гематолог","Гемостазиолог","Гепатолог","Гинеколог","Гинеколог-эндоккринолог","Генетик"
        ,"Дерматовенеролог","Дерматолог", "Дефектолог","Диабетолог", "Диетолог",
        "Иммунолог","Инфекционист","Кардиолог","Кардиохирург","Косметолог","Логопед", "Лор (отоларинголог)",
        "Маммалог","Мануальный терапевт","Массажист","Нарколог","Невролог","Нейрохирург"
        ,"Нефролог","Окулист", "Онколог","Ортопед", "Остеопат",
        "Офтальмохирург","Паразитолог","Педиатр","Пластический хирург","Проктолог","Психиатр", "Пульмонолог",
        "Реабилитолог","Ренгенолог","Репродуктолог (ЭКО)","Сексолог","Семейный врач","Стомотолог"
        ,"Стомотолог-имплантолог","Стомотолог-ортодонт", "Стомотолог-ортопед","Стомотолог-хирург", "Терапевт",
        "Травматолог","Трихолог","УЗИ-специалист","Уролог","Физиотерапевт","Хирург"
        ,"Челюстно-лицевой хирург","Эндокринолог")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCategoryDoctor {
        return ViewHolderCategoryDoctor(ItemCategoryDoctorsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolderCategoryDoctor, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolderCategoryDoctor(
       private val binding:ItemCategoryDoctorsBinding
   ):RecyclerView.ViewHolder(binding.root) {
        fun bind(letter: String) {
            binding.tvProf.text=letter
        }
    }

}