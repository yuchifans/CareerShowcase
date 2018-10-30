package com.alaskalany.careershowcase.ui.education;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.data.education.Education;
import com.alaskalany.careershowcase.databinding.FragmentEducationBinding;
import com.alaskalany.careershowcase.ui.education.EducationListFragment.OnEducationListFragmentInteractionListener;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Education} and makes a call to the
 * specified {@link OnEducationListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class EducationRecyclerViewAdapter
        extends RecyclerView.Adapter<EducationViewHolder> {

    private final SparseArray<Education> mValues;
    private final OnEducationListFragmentInteractionListener mListener;

    @SuppressWarnings("WeakerAccess")
    public EducationRecyclerViewAdapter(SparseArray<Education> items,
                                        OnEducationListFragmentInteractionListener listener) {

        mValues = items;
        mListener = listener;
    }

    @NonNull
    @Override
    public EducationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        FragmentEducationBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                                                                   R.layout.fragment_education,
                                                                   parent,
                                                                   false);
        return new EducationViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final EducationViewHolder holder, int position) {

        holder.mBinding.setEducation(mValues.get(position));
        holder.mBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {

        return mValues.size();
    }
}