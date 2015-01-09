import java.util.List;
import java.util.ArrayList;

public class CandidatePool
{
    private List<Candidate> pool;
    
    /**
     * Constructor initializes Candidate list
     */
    public CandidatePool()
    {
        pool = new ArrayList<Candidate>();
    }
    
    /**
     * Adds a new candidate object to the candidate list.
     */
    public void addCandidate(Candidate candidate)
    {
        pool.add(candidate);
    }
    
    /**
     * Returns a list object of all candidates for the specified position.
     */
    public List<Candidate> getCandidatesForPosition(String position)
    {
        ArrayList<Candidate> candidatesForPosition = new ArrayList<Candidate>();
        
        for(Candidate c : pool)
        {
            if(c.getPosition().equalsIgnoreCase(position))
            {
                candidatesForPosition.add(c);
            }
        }
        return candidatesForPosition;
    }
    
    /**
     * Returns the candidate with the best score out of a list of candidates
     * for a position.
     */
    public Candidate getBestCandidate(String position)
    {
        ArrayList<Candidate> candidateList = getCandidatesForPosition(position);
        Candidate bestCandidate = new Candidate(-1, position, 0);
        
        for(Candidate c : candidateList)
        {
            if(c.getInterviewScore() > bestCandidate.getInterviewScore())
            {
                bestCandidate = c;
            }
        }
        return bestCandidate;
    }
    
    /**
     * Remove all candidates for a certain position from the pool.
     * @return The number of candidates removed.
     */
    public int removeCandidatesForPosition(String position)
    {
        int candidatesRemoved = 0;
        
        /*
         * Repetitively calles the remove method until no more candidates for the
         * position left.
         */
        while(!_removeCandidateForPosition(position))
        {
            candidatesRemoved++;
        }
        return candidatesRemoved;
    }
    
    /**
     * Behind-the-scenes method for removing a single candidate oject from the
     * pool for a certain position.  This is called repetitively.
     * @return False if there are more candidate objects to remove, true if there
     * are no more candidates for that position in the pool.
     */
    private boolean _removeCandidateForPosition(String position)
    {
        for(int i = 0; i < pool.size(); i++)
        {
            if(pool.get(i).getPosition().equalsIgnoreCase(position))
            {
                pool.remove(i);
                return false;
            }
        }
        return true;
    }
}