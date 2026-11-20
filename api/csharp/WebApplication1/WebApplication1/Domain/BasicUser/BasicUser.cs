using WebApplication1.Domain;

namespace WebApplication1.Domain.BasicUser;

public class BasicUser
{
    
    public Guid Id { get; private set; }
    public FullName FullName { get; private set; } = null!;
    public BirthDate BirthDate { get; private set; } = null!;
    public Email Email { get; private set; } = null!;
    public PhoneNumber PhoneNumber { get; private set; } = null!;
    public DateTime CreatedAt { get; private set; }

    private BasicUser() { }

    private BasicUser(
        string firstName,
        string? middleName,
        string lastName,
        DateOnly birthDate,
        string email,
        string phoneNumber)
    {
        Id = Guid.NewGuid();
        FullName = new FullName(firstName, middleName, lastName);
        BirthDate = new BirthDate(birthDate);
        Email = new Email(email);
        PhoneNumber = new PhoneNumber(phoneNumber);
        CreatedAt = DateTime.UtcNow;
    }

    public static BasicUser Create(
        string firstName,
        string? middleName,
        string lastName,
        DateOnly birthDate,
        string email,
        string phoneNumber)
    {
        return new BasicUser(
            firstName,
            middleName,
            lastName,
            birthDate,
            email,
            phoneNumber);
    }
}