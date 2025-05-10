package com.example.geeks_pro_xml.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.geeks_pro_xml.data.Hero
import com.example.geeks_pro_xml.databinding.ItemBinding

class HeroListAdapter(
    private var heroList: List<Hero>,
    private val onClick: (Hero) -> Unit
) : RecyclerView.Adapter<HeroListAdapter.HeroViewHolder>() {

    inner class HeroViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hero: Hero) {
            binding.textView.text = hero.name
            Glide.with(binding.root)
                .load(hero.image)
                .into(binding.imageView)

            binding.root.setOnClickListener {
                onClick(hero)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = heroList[position]
        holder.bind(hero)
    }

    override fun getItemCount(): Int = heroList.size

    fun updateData(newHeroList: List<Hero>) {
        heroList = newHeroList
        notifyDataSetChanged()
    }
}
