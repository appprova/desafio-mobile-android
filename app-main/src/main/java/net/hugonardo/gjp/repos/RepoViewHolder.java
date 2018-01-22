package net.hugonardo.gjp.repos;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import net.hugonardo.gjp.api.repo.Repo;
import net.hugonardo.gjp.databinding.RepoListItemBinding;

class RepoViewHolder extends BaseViewHolder<Repo> {

    private final RepoListItemBinding mBinding;

    RepoViewHolder(RepoListItemBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
        binding.setViewModel(new RepoListItemViewModel());
    }

    @Override
    public void setData(Repo data) {
        mBinding.getViewModel().setModel(data);
        mBinding.executePendingBindings();
    }
}
