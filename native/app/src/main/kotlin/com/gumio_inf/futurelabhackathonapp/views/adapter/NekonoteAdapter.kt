package com.gumio_inf.futurelabhackathonapp.views.adapter



/**
 * Created by gumio_inf on 2018/01/28.
 */
//class NekonoteAdapter(private val mImages: List<Int>?,
//                      private val mNames: List<String>?,
//                      private val mTimes: List<String>?
//): RecyclerView.Adapter<NekonoteAdapter.ViewHolder>() {
//
////    private val mImages: List<Int>? = null
////    private val mNames: List<String>? = null
////    private val mTimes: List<String>? = null
//
//    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//        var mImageView: ImageView? = itemView.findViewById(R.id.image_view) as? ImageView
//        var mNameTextView: TextView? = itemView.findViewById(R.id.name_view) as? TextView
//        var mTimeTextView: TextView? = itemView.findViewById(R.id.time_view) as? TextView
//
////        companion object Factory {
////            fun create(v: View): ViewHolder = ViewHolder(v)
////        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
//        val v: View = LayoutInflater.from(parent?.context).inflate(R.layout.nekonote_list, parent, false)
//        val vh: ViewHolder = ViewHolder(v)
//        return vh
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
//        mImages?.get(position)?.let { holder?.mImageView?.setImageResource(it) }
//        mNames?.get(position)?.let { holder?.mNameTextView?.setText(it) }
//        mTimes?.get(position)?.let { holder?.mTimeTextView?.setText(it) }
//    }
//
//    override fun getItemCount(): Int {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//}