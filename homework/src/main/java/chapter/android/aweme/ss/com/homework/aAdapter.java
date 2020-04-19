package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

public class aAdapter extends RecyclerView.Adapter<aAdapter.ViewHolder>{

    private static final String TAG="aAdapter";
    private List<Message> msglist;
    private final ListItemClickListener mOnClickListener;

    public aAdapter(List<Message> msglist, ListItemClickListener listener) {
        this.msglist = msglist;
        this.mOnClickListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView tv_title;
        private final TextView tv_description;
        private final TextView tv_time;
        private final CircleImageView iv_avatar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_avatar=(CircleImageView) itemView.findViewById(R.id.iv_avatar);
            tv_title=(TextView) itemView.findViewById(R.id.tv_title);
            tv_description=(TextView) itemView.findViewById(R.id.tv_description);
            tv_time=(TextView) itemView.findViewById(R.id.tv_time);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            if (mOnClickListener != null) {
                mOnClickListener.onListItemClick(clickedPosition);
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.im_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Log.d(TAG, "onBindViewHolder: #" + position);
        Message m1 = msglist.get(position);
        viewHolder.tv_title.setText(m1.getTitle());
        viewHolder.tv_description.setText(m1.getDescription());
        viewHolder.tv_time.setText(m1.getTime());
        viewHolder.iv_avatar.setImageResource(m1.getId());
    }

    @Override
    public int getItemCount() {
        return msglist.size();
    }


    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}
