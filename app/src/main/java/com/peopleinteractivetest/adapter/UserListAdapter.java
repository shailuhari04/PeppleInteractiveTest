package com.peopleinteractivetest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.peopleinteractivetest.R;
import com.peopleinteractivetest.databinding.RowItemUserListBinding;
import com.peopleinteractivetest.pojo.response.Result;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private List<Result> list;
    private OnActionClickLstener actionClickLstener;

    public UserListAdapter(List<Result> list, OnActionClickLstener actionClickLstener) {
        this.list = list;
        this.actionClickLstener = actionClickLstener;
    }

    public void setList(List<Result> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        RowItemUserListBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.row_item_user_list, parent, false);
        return new UserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final UserViewHolder holder, final int position) {
        String name = list.get(position).getName().getFirst() + " " + list.get(position).getName().getLast();
        String info = list.get(position).getDob().getAge() + "yrs, " + list.get(position).getLocation().getStreet() + ", " + list.get(position).getLocation().getCity() + ", " + list.get(position).getLocation().getState() + ", " + list.get(position).getLocation().getPostcode();
        String time = "few hours ago";

        holder.binding.setName(name);
        holder.binding.setInfo(info);
        holder.binding.setReceiveTime(time);

        Picasso.get().load(list.get(position).getPicture().getThumbnail()) // thumbnail url goes here
                .error(R.drawable.ic_error_img)
                .into(holder.binding.profileImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        Picasso.get().load(list.get(position).getPicture().getLarge()) // image url goes here
                                .into(holder.binding.profileImage);
                    }

                    @Override
                    public void onError(Exception e) {

                    }

                });

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final RowItemUserListBinding binding;

        public UserViewHolder(@NonNull RowItemUserListBinding binding_) {
            super(binding_.getRoot());
            this.binding = binding_;
            binding.cvAccept.setOnClickListener(this);
            binding.cvDecline.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.cvAccept:
                    actionClickLstener.onAcceptClick(getAdapterPosition(), binding.cvRowItem);
                    break;

                case R.id.cvDecline:
                    actionClickLstener.onDeclineClick(getAdapterPosition(), binding.cvRowItem);
                    break;
            }
        }
    }

    /**
     * Define Listener for recyclerView item action handling.
     */
    public interface OnActionClickLstener {

        void onDeclineClick(int position, View cvRowItem);

        void onAcceptClick(int position, View v);
    }
}
