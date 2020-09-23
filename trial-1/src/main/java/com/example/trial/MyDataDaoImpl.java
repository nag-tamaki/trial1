package com.example.trial;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class MyDataDaoImpl implements MyDataDao<MyData> {

	public static final long serialVersionID = 1L;
	private EntityManager entityManager;

	public MyDataDaoImpl() {
		super();
	}

	public MyDataDaoImpl(EntityManager manager) {
		this();
		entityManager = manager;
	}
/*
	@Override
	public List<MyData> getAll(){
		Query query = entityManager.createQuery("from MyData");

		@SuppressWarnings("unchecked")
		List <MyData> list = query.getResultList();
		entityManager.close();
		return list;
	}
*/

	@Override
	public List<MyData> find(String fstr){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MyData> query = builder.createQuery(MyData.class);
		Root<MyData> root = query.from(MyData.class);
		query.select(root).where(builder.notEqual(root.get("name"), fstr));
		List<MyData> list = null;
		list = (List<MyData>) entityManager
				.createQuery(query)
				.getResultList();
		return list;
	}

	@Override
	public List<MyData> getAll(){
		List<MyData> list = null;

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MyData> query = builder.createQuery(MyData.class);
		Root<MyData> root = query.from(MyData.class);
		query.select(root).orderBy(builder.desc(root.get("id")));
		list = (List<MyData>)entityManager.createQuery(query).getResultList();

		return list;
	}

	@Override
	public MyData findById(long id) {
		return (MyData)entityManager.createQuery("from MyData where id =" + id).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MyData> findByName(String name){
		return (List<MyData>)entityManager.createQuery("from MyData where name = " + name).getResultList();
	}
/*
	@SuppressWarnings("unchecked")
	@Override
	public List<MyData> find(String fstr){
		List<MyData> list = null;
		String qstr = "from MyData where id = :fid or name like :fname or mail like :fmail";
		Long fid = 0L;
		try {
			fid = Long.parseLong(fstr);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		Query query = entityManager.createNamedQuery("findWithName")
									.setParameter("fname", "%" + fstr + "%");

		Query query = entityManager.createQuery(qstr).setParameter("fid", fid)
				.setParameter("fname", "%" + fstr + "%")
				.setParameter("fmail", fstr + "@%");

		list = query.getResultList();
		return list;

	}
*/
	@SuppressWarnings("unchecked")
	@Override
	public List<MyData> findByAge(int min, int max){
		return (List<MyData>)entityManager
				.createNamedQuery("findByAge")
				.setParameter("min", min)
				.setParameter("max", max)
				.getResultList();

	}

}
