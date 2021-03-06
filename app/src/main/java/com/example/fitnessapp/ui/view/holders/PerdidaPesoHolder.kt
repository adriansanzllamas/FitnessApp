package com.example.fitnessapp.ui.view.holders

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fitnessapp.R
import com.example.fitnessapp.data.models.Perdidapeso
import com.example.fitnessapp.databinding.ItemRecetaBinding
import com.example.fitnessapp.ui.view.TAG_LOGS
import com.google.firebase.firestore.FirebaseFirestore


val listaf= mutableListOf<Int>()
var color=false

val db2 = FirebaseFirestore.getInstance()

class PerdidaPesoHolder(val context: Context,val listaperdidpeso: MutableList<Perdidapeso>) :
    RecyclerView.Adapter<PerdidaPesoHolder.ViewHolder>() {



    @RequiresApi(Build.VERSION_CODES.N)
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var binding= ItemRecetaBinding.bind(itemView)
        var titulo=binding.NombreReceta
        var foto=binding.fotoreceta
        var information=binding.informacion
        var calorias=binding.calorias
        var tiempo=binding.tiempo

        init {
            binding.favorito.setOnClickListener {

                if (true){


                    binding.favorito.setImageResource(R.drawable.ic_baseline_star_24ye)
                    listaf.add(position)
                    Log.i(TAG_LOGS, listaf.toString())

                }


            }

        }
    }
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerdidaPesoHolder.ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.item_receta, parent, false)
        return PerdidaPesoHolder.ViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: PerdidaPesoHolder.ViewHolder, position: Int) {
        holder.titulo.text= listaperdidpeso[position].titulo
        Glide.with(context).load(listaperdidpeso[position].foto).into(holder.foto)
        holder.information.text=listaperdidpeso[position].informacion
        holder.calorias.text=listaperdidpeso[position].calorias
        holder.tiempo.text=listaperdidpeso[position].tiempo



    }

    override fun getItemCount(): Int {
        return listaperdidpeso.size

    }


}




