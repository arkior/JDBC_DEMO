package co.simplon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import co.simplon.model.Pays;




public class DAOPays extends DAOContext implements DAO<Pays>{

	private final String LISTE_PAYS = "SELECT * FROM test_jdbc.pays"; 
	private final String AJOUTER_PAYS = "INSERT INTO test_jdbc.pays(nom) VALUES(?)";
	private final String DELETE = "DELETE FROM test_jdbc.pays WHERE pays.id = ?";
	private final String REINITIALISATION_AUTO_INCREMENT= "ALTER TABLE test_jdbc.pays AUTO_INCREMENT=0";
	private final String SEARCH = "SELECT nom FROM test_jdbc.pays WHERE pays.id = ?";
	private final String UPDATE = "UPDATE test_jdbc.pays SET pays.nom = ? WHERE pays.id = ?";
	
	private DAOContext daoContext;
	private Connection connection;

	public DAOPays(DAOContext daoContext) 
	{
		this.daoContext = daoContext;
	}
	
	@Override
	public void ajouter(Pays t)
	{
		try
		{
			this.connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword );
			PreparedStatement prepareEtat= this.connection.prepareStatement(this.AJOUTER_PAYS);
			prepareEtat.setString(1,t.getNom());
			 boolean result = prepareEtat.execute();
			 System.out.println("verif de l'insertion"+result);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public List<Pays> lister()
	{
		List<Pays> listePays = new ArrayList<>();
		try
		{
			this.connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword );
			PreparedStatement prepareEtat= this.connection.prepareStatement(this.LISTE_PAYS);
			ResultSet rs = prepareEtat.executeQuery();
			while (rs.next())
			{
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				
				Pays pays = new Pays( id , nom);
				
				listePays.add(pays);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return listePays;
	}

	@Override
	public Pays find(int id)
	{
		Pays pays = null;
		try
		{
			this.connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword );
			PreparedStatement prepareEtat= this.connection.prepareStatement(this.SEARCH);
			prepareEtat.setInt(1,id);
			ResultSet rs = prepareEtat.executeQuery();
			
			if(rs.next()) {
				String nom = rs.getString("nom");
				
				pays = new Pays(id,nom);
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return pays;
	}



	@Override
	public boolean delete(Pays t)
	{
		
		
			 boolean delete = false;
			try
			{
				this.connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword );
				
				 PreparedStatement prepareEtat= this.connection.prepareStatement(this.DELETE);
				prepareEtat.setInt(1,t.getId());
			    delete = prepareEtat.execute();
			    PreparedStatement requetePreparee1= this.connection.prepareStatement(this.REINITIALISATION_AUTO_INCREMENT);
			    requetePreparee1.execute();
			   
				

			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			return delete;
			
	}
	@Override
	public boolean update(Pays obj) {
		boolean resultat= false;
		try
		{
			this.connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword );
			PreparedStatement requetePreparee= this.connection.prepareStatement(this.UPDATE);
			requetePreparee.setString(1,obj.getNom());
			requetePreparee.setInt(2,obj.getId());
			resultat = requetePreparee.execute();
				

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return resultat;
	}

	

}
