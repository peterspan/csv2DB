package de.peterspan.csv2db.domain.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;

import de.peterspan.csv2db.domain.entities.DataSet;
import de.peterspan.csv2db.domain.entities.Location;
import de.peterspan.csv2db.domain.entities.Values;

/**
 * This class provides all default operations that are derived from the HEDL entity model.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public abstract class OperationProviderBase implements IDBOperationsBase {
		
	private Session session;
	
	private LocationDAO locationDAO = new LocationDAO();
	private DataSetDAO dataSetDAO = new DataSetDAO();
	private ValuesDAO valuesDAO = new ValuesDAO();

	public OperationProviderBase(Session session) {
		this.session = session;
	}
	
	public Session getSession() {
		return session;
	}
	
	public void update(Object entity) {
		getSession().update(entity);
	}
	
	/** 
	 * Creates an instance of type Location using all read-only and all non-null properties.
	 */
	public Location createLocation(double longitude, double latitude, java.lang.String name, int locationNumber) {
		return locationDAO.create(session, longitude, latitude, name, locationNumber);
	}
	
	/**
	 * Returns the Location with the given id.
	 */
	public Location getLocation(int id) {
		Location entity = locationDAO.get(session, id);
		return entity;
	}
	
	/** Returns the Location with the given locationNumber. */
	public Location getLocationByLocationNumber(int locationNumber) {
		Location entity = locationDAO.getByLocationNumber(session, locationNumber);
		return entity;
	}
		
	/**
	 * Returns all entities of type Location.
	 */
	public List<Location> getAllLocations() {
		final List<Location> entities = locationDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type Location.
	 */
	public List<Location> searchLocations(String _searchString, int _maxResults) {
		return locationDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a Location.
	 */
	public void delete(Location entity) {
		locationDAO.delete(session, entity);
	}
	
		/**
	 * Counts the number of Location entities.
	 */
	public int countLocations() {
		return locationDAO.count(session);
	}
	
	/** 
	 * Creates an instance of type DataSet using all read-only and all non-null properties.
	 */
	public DataSet createDataSet(java.util.Date acquisitionDate, int standingYear, int rotation, int treeType, int repetition) {
		return dataSetDAO.create(session, acquisitionDate, standingYear, rotation, treeType, repetition);
	}
	
	/**
	 * Returns the DataSet with the given id.
	 */
	public DataSet getDataSet(int id) {
		DataSet entity = dataSetDAO.get(session, id);
		return entity;
	}
	
	/** Returns the DataSets with the given location. */
	public List<DataSet> getDataSetsByLocation(Location location) {
		List<DataSet> entities = dataSetDAO.getByLocation(session, location);
		return entities;
	}
		
	/** Returns the DataSets with the given values. */
	public List<DataSet> getDataSetsByValues(Values values) {
		List<DataSet> entities = dataSetDAO.getByValues(session, values);
		return entities;
	}
		
	/**
	 * Returns all DataSets where acquisitionDate is set to a value before '_maxDate'.
	 */
	public List<DataSet> getDataSetsWithAcquisitionDateBefore(java.util.Date _maxDate) {
		final List<DataSet> entities = dataSetDAO.getAcquisitionDateBefore(session, _maxDate);
		return entities;
	}
	
	/**
	 * Returns all DataSets where acquisitionDate is set to a value after '_minDate'.
	 */
	public List<DataSet> getDataSetsWithAcquisitionDateAfter(java.util.Date _minDate) {
		final List<DataSet> entities = dataSetDAO.getAcquisitionDateAfter(session, _minDate);
		return entities;
	}
	
	/**
	 * Returns all entities of type DataSet.
	 */
	public List<DataSet> getAllDataSets() {
		final List<DataSet> entities = dataSetDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type DataSet.
	 */
	public List<DataSet> searchDataSets(String _searchString, int _maxResults) {
		return dataSetDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type DataSet.
	 */
	public List<DataSet> searchDataSetWithLocation(Location location, String _searchString, int _maxResults) {
		return dataSetDAO.searchWithLocation(session, location, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type DataSet.
	 */
	public List<DataSet> searchDataSetWithValues(Values values, String _searchString, int _maxResults) {
		return dataSetDAO.searchWithValues(session, values, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a DataSet.
	 */
	public void delete(DataSet entity) {
		dataSetDAO.delete(session, entity);
	}
	
		/**
	 * Deletes all DataSets where acquisitionDate is set to a value before '_maxDate'.
	 */
	public void deleteDataSetsWithAcquisitionDateBefore(java.util.Date _maxDate) {
		Query query = getSession().createQuery(
			"DELETE FROM " + DataSet.class.getName() + " " +
			"WHERE " + DataSetDAO.FIELD__ACQUISITIONDATE + " < ?"
		);
		query.setParameter(0, _maxDate);
		query.executeUpdate();
	}
	
	/**
	 * Deletes all DataSets where acquisitionDate is set to a value after '_minDate'.
	 */
	public void deleteDataSetsWithAcquisitionDateAfter(java.util.Date _minDate) {
		Query query = getSession().createQuery(
			"DELETE FROM " + DataSet.class.getName() + " " +
			"WHERE " + DataSetDAO.FIELD__ACQUISITIONDATE + " > ?"
		);
		query.setParameter(0, _minDate);
		query.executeUpdate();
	}
	
		/**
	 * Counts the number of DataSet entities.
	 */
	public int countDataSets() {
		return dataSetDAO.count(session);
	}
	
	/** 
	 * Creates an instance of type Values using all read-only and all non-null properties.
	 */
	public Values createValues() {
		return valuesDAO.create(session);
	}
	
	/**
	 * Returns the Values with the given id.
	 */
	public Values getValues(int id) {
		Values entity = valuesDAO.get(session, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Values.
	 */
	public List<Values> getAllValuess() {
		final List<Values> entities = valuesDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type Values.
	 */
	public List<Values> searchValuess(String _searchString, int _maxResults) {
		return valuesDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a Values.
	 */
	public void delete(Values entity) {
		valuesDAO.delete(session, entity);
	}
	
		/**
	 * Counts the number of Values entities.
	 */
	public int countValuess() {
		return valuesDAO.count(session);
	}
	
	/**
	 * Returns the name of the table that contains entities of the given type.
	 */
	public String getTableName(Class<?> clazz) {
		ClassMetadata hibernateMetadata = getSession().getSessionFactory().getClassMetadata(clazz);
		if (hibernateMetadata == null) {
		    return null;
		}
		if (hibernateMetadata instanceof AbstractEntityPersister) {
		     AbstractEntityPersister persister = (AbstractEntityPersister) hibernateMetadata;
		     return persister.getTableName();
		}
		return null;
	}
}