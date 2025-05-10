package com.example.geeks_pro_xml.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geeks_pro_xml.R
import com.example.geeks_pro_xml.data.Hero
import com.example.geeks_pro_xml.databinding.FragmentHomeBinding
import com.example.geeks_pro_xml.ui.adapter.HeroListAdapter


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding ?= null
    private val binding get() = _binding!!
    private var heroList: ArrayList<Hero> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        initialize()

    }
    private fun loadData() {

        heroList.add(
            Hero(
                name = "Доктор Стрендж",
                image = "https://static.kinoafisha.info/upload/news/666313086653.jpg",
                description = "Могущественный маг и хранитель Камня Времени, защищает мир от мистических угроз."
            )
        )

        heroList.add(
            Hero(
                name = "Кратос",
                image = "https://static.wikia.nocookie.net/deadliestfiction/images/e/ea/Kratos_God_of_War.jpg/revision/latest?cb=20110724174328",
                description = "Спартанец и Бог войны, мститель, сражающийся с богами и монстрами в эпической саге."
            )
        )

        heroList.add(
            Hero(
                name = "Алекс Мерсер",
                image = "https://comicvine.gamespot.com/a/uploads/scale_super/11156/111569405/9210133-alexmercer.jpg",
                description = "Учёный, ставший сверхчеловеком с возможностью принимать любые формы и разрушать всё на пути."
            )
        )

        heroList.add(
            Hero(
                name = "Спаун",
                image = "https://sun9-48.userapi.com/impg/PXw6c2N7Y518LaYqIn_JIkw3mUW62oqH_VOtfg/BFHUhf2AHOM.jpg?size=1080x1080&quality=96&sign=134e53ae365a2014ae694c06f2837153&c_uniq_tag=0sqjlmzJf6ZDuqu48Pf1HMRjcz5ThEraFR7xuhZba4g&type=album",
                description = "Бывший наёмник, заключивший сделку с дьяволом, чтобы вернуться с адскими силами."
            )
        )

        heroList.add(
            Hero(
                name = "Тор",
                image = "https://i.pinimg.com/736x/ab/dd/8d/abdd8d3374f7b924c0323fc742b3f279.jpg",
                description = "Бог грома из Асгарда, владеющий молотом Мьёльниром и защищающий вселенные от зла."
            )
        )

        heroList.add(
            Hero(
                name = "Москов",
                image = "https://m.media-amazon.com/images/M/MV5BNGIzNjMyOGMtMzAzNi00MTY1LTgxNTMtN2FhOTk0NjVkZGRkXkEyXkFqcGdeQXVyMTA2MjIzMDM0._V1_.jpg",
                description = "Мастер по туннелям и подкопам, участник ограбления века в 'Бумажном доме'."
            )
        )

        heroList.add(
            Hero(
                name = "Солдатик",
                image = "https://s0.rbk.ru/v6_top_pics/media/img/1/05/347030907809051.webp",
                description = "Жестокий и харизматичный супергерой из мира 'Пацанов', пародия на Капитана Америку."
            )
        )
    }

    private fun initialize() {
        val heroAdapter = HeroListAdapter(heroList) { hero ->
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(hero)
            findNavController().navigate(action)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = heroAdapter
        heroAdapter.updateData(heroList)
    }

}