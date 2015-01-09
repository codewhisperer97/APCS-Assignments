import java.util.ArrayList;

public class CandidateTester
{
    public static void main(String[] args)
    {
        CandidatePool pool = new CandidatePool();
        pool.addCandidate(new Candidate(1, "Marketing", 6));
        pool.addCandidate(new Candidate(2, "IT", 8));
        pool.addCandidate(new Candidate(3, "Secretary", 5));
        pool.addCandidate(new Candidate(4, "IT", 4));
        pool.addCandidate(new Candidate(5, "Custodian", 6));
        pool.addCandidate(new Candidate(6, "Marketing", 9));
        pool.addCandidate(new Candidate(7, "Custodian", 2));
        pool.addCandidate(new Candidate(8, "IT", 10));
        pool.addCandidate(new Candidate(9, "Secretary", 3));
        pool.addCandidate(new Candidate(10, "Secretary", 8));
        
        ArrayList<Candidate> candidatesForPosition = pool.getCandidatesForPosition("IT");
        for(Candidate c : candidatesForPosition)
        {
            System.out.print(c.getIdNumber() + " | ");
        }
        System.out.println();
        System.out.println();
        
        Candidate bestCandidate = pool.getBestCandidate("Secretary");
        System.out.println(bestCandidate.getIdNumber());
    }
}