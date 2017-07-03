package dao;

import java.util.List;

import model.BorrowComment;

public interface BorrowCommentDao {

	public Integer save(BorrowComment borrowComment);

	public void delete(BorrowComment borrowComment);

	public void update(BorrowComment borrowComment);

	public BorrowComment getBorrowCommentByH_id(int h_id);

	public List<BorrowComment> getAllBorrowComments();

}