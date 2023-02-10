package com.example.ssuthing.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ssuthing.R
import com.example.ssuthing.data.ItemListData

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PatrolPageFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_patrol_page, container, false)
        val rv_patrol = view.findViewById<RecyclerView>(R.id.rv_patrol)
        val itemList = ArrayList<ItemListData>()
        itemList.add(ItemListData("경관봉", 5))
        itemList.add(ItemListData("형광조끼", 4))
        itemList.add(ItemListData("호루라기", 2))
        itemList.add(ItemListData("모자", 6))
        val patrolPageAdapter = PatrolPageAdapter(itemList)
        patrolPageAdapter.notifyDataSetChanged()
        rv_patrol.adapter = patrolPageAdapter
        rv_patrol.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        patrolPageAdapter.itemClickListener = object : PatrolPageAdapter.OnItemClickListener{
            override fun onItemClick(position: Int){
                val item = itemList[position]
                val bottomSheet = ReserveBottomSheetFragment()
                activity?.let { bottomSheet.show(it.supportFragmentManager, bottomSheet.tag) }
            }
        }
        return view
    }
}