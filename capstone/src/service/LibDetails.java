package service;

import java.util.ArrayList;

import dao.LibDao;
import model.LibModel;

public class LibDetails implements aDetails{
	LibDao libDao = new LibDao();
	ArrayList<LibModel> libList = new ArrayList<LibModel>();
	public void addlibToList(LibModel lm) throws ClassNotFoundException {
		libList.add(lm);
		libDao.storeLibRecordInDb(libList);
	}

}