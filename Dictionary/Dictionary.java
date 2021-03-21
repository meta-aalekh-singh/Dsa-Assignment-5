import java.util.*;

public interface Dictionary {
	public boolean add(String key, String value) throws Exception;

	public boolean delete(String key) throws Exception;

	public String getValue(String key);

	public List<Value> getAll();

	public List<Value> getBetween(String key1, String key2);
}