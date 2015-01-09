public class Candidate
{
    private int idNumber;
    private String position;
    private double interviewScore;
    
    public Candidate(int idNumber, String position, double interviewScore)
    {
        this.idNumber = idNumber;
        this.position = position;
        this.interviewScore = interviewScore;
    }
    
    public int getIdNumber()
    {
        return this.idNumber;
    }
    
    public String getPosition()
    {
        return this.position;
    }
    
    public double getInterviewScore()
    {
        return this.interviewScore;
    }
}