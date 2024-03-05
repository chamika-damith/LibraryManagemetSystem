package org.example.bo.custom.impl;

import org.example.bo.custom.BranchBO;
import org.example.dao.DAOFactory;
import org.example.dao.custom.BranchDAO;
import org.example.dto.BookDto;
import org.example.dto.BranchDto;
import org.example.entity.Branch;

import java.util.List;

public class BranchBOImpl implements BranchBO {

    private BranchDAO branchDAO= (BranchDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOType.BRANCH);
    @Override
    public boolean addBranch(BranchDto dto) {
        return branchDAO.add(new Branch(dto.getBranchId(),dto.getBranchName(),dto.getBranchLocation()));
    }

    @Override
    public List<BranchDto> getAllBranch() {
        return null;
    }

    @Override
    public boolean updateBranch(BranchDto dto) {
        return branchDAO.update(new Branch(dto.getBranchId(),dto.getBranchLocation(),dto.getBranchName()));
    }

    @Override
    public boolean isExistBranch(String id) {
        return branchDAO.isExists(id);
    }

    @Override
    public BranchDto searchBranch(String id) {
        Branch search = branchDAO.search(id);
        BranchDto branchDto = new BranchDto(search.getBranchId(),search.getBranchName(),search.getBranchLocation());
        return branchDto;
    }

    @Override
    public boolean deleteBranch(String id) {
        return false;
    }
}
