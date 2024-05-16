import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Comparator;

public class Heap<K, V> implements PriorityQueue<K, V>{
	
	public List<Entry<K, V>> entries;
	public Comparator<K> comparator;
	
	public Heap(Comparator comparator)
	{
		this.comparator = comparator;
		entries = new ArrayList<>();
	
	}
	
	public void add(K k, V v) {
		Entry<K, V> e = new Entry<>(k, v);
		entries.add(e);
		while(this.comparator.compare(e.getKey(), (entries.get(parent(entries.indexOf(e))).getKey())) > 0)
		{
			bubbleUp(entries.indexOf(e));
		}
	}

	public Entry<K, V> poll(){
		if(isEmpty())
		{
			throw new NoSuchElementException();
		}
		Entry<K,V> submit = this.entries.get(0);
		this.entries.set(0, this.entries.get(this.entries.size()-1));
		this.entries.remove(this.entries.size()-1);
		int index = 0;
		int newIndex;
		
		while (left(index) < this.entries.size() || right(index) < this.entries.size())
		{
			
			
			if (left(index) >= this.entries.size())
			{
				
				
				if (this.comparator.compare(this.entries.get(index).getKey(), this.entries.get(right(index)).getKey()) < 0)
				{
					newIndex = right(index);
					swap(index, right(index));
					index = newIndex;
				}
				else
				{
					return submit;
				}
			}
			else if (right(index) >= this.entries.size())
			{
				System.out.println(right(index));
				
				if (this.comparator.compare(this.entries.get(index).getKey(), this.entries.get(left(index)).getKey()) < 0)
				{
					newIndex = left(index);
					swap(index, left(index));
					index = newIndex;
				}
				else
				{
					return submit;
				}
			}
			else
			{
				
				if (this.comparator.compare((this.entries.get(left(index)).getKey()), this.entries.get(right(index)).getKey()) > 0)
				{
					
					if (this.comparator.compare(this.entries.get(index).getKey(), this.entries.get(left(index)).getKey()) < 0)
					{
						newIndex = left(index);
						swap(index, left(index));
						index = newIndex;
					}
					else
					{
						return submit;
					}
				}
				else
				{
					
					if (this.comparator.compare(this.entries.get(index).getKey(), this.entries.get(right(index)).getKey()) < 0)
					{
						newIndex = right(index);
						swap(index, right(index));
						index = newIndex;
					}
					else
					{
						return submit;
					}
				}
			}
		}
		return submit;
	}

	public Entry<K, V> peek(){
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}
		return this.entries.get(0);
	}

	public List<Entry<K, V>> toArray(){
		return this.entries;
	}

	public boolean isEmpty() {
		if (entries.size() == 0)
		{
			return true;
		}
		return false;
	}
	public int parent(int index){
		
		return (index - 1)/2;
	}
	public int left(int index){
		//this needs to be dealt with
		return (2*index)+1;
	}
	public int right(int index){
		//this needs to be dealt with
		return (2*index)+2;
	}
	public void swap(int i1, int i2){
		Entry<K, V> temp = this.entries.get(i1);
		this.entries.set(i1, this.entries.get(i2));
		this.entries.set(i2, temp);
	}
	public void bubbleUp(int index){
		
		swap(index, parent(index));
		
	}
	public void bubbleDown(int index){
		
		if(this.comparator.compare(this.entries.get(left(index)).getKey(), this.entries.get(right(index)).getKey()) < 0)
		{
			swap(index, left(index));
		}
		else
		{
			swap(index, right(index));
		}
		
	}
	public boolean existsAndGreater(int index1, int index2){
		if (index1 < this.entries.size() && index2 < this.entries.size())
		{
			if (this.comparator.compare(this.entries.get(index1).getKey(), this.entries.get(index2).getKey()) > 0)
			{
				return true;
			}
			return false;
			
		}
		else
		{
			return false;
		}
	}
	
	public int size(){
		return this.entries.size();
	}
	
	public String toString(){
		String submit = "";
		if (isEmpty())
		{
			return submit;
		}
		else
		{
			for (int i = 0; i < this.entries.size(); i++)
			{
				submit += this.entries.get(i).toString() + "  ";
			}
		}
		return submit;
	}

}
