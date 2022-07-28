package com.gachonumc.threejeon.mymenu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gachonumc.threejeon.databinding.ItemStoreBinding

class MyMenuAdapter() : RecyclerView.Adapter<MyMenuAdapter.ViewHolder>() {

    //어댑터에서 관리하는 아이템의 갯수 반환
    override fun getItemCount() = MyMenuData.values().size

    //아이템뷰와 뷰홀더를 생성하여 반환
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ItemStoreBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(binding)
    }

    //뷰홀더에 데이터 바인딩
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindStoreData(MyMenuData.values()[position])
    }

    //뷰홀더 클래스 선언
    inner class ViewHolder(private val binding: ItemStoreBinding) : RecyclerView.ViewHolder(binding.root) {

        //item_store 레이아웃에 StoreData 데이터 바인딩
        fun bindStoreData(storeData: MyMenuData){
            binding.storeItemImg.setImageResource(storeData.imgMyMenu)
            binding.storeItemName.text = storeData.MyMenuName
            binding.storeItemName.text = storeData.MyMenuPrice

            /*
            // 리사이클러뷰의 뷰홀더를 클릭하면 상세보기 화면 생성

            itemView.setOnClickListener{
                val intent = Intent(itemView.context, Detail)
            }*/
        }
    }
}