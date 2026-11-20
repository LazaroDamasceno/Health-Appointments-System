using WebApplication1.Domain.Exceptions;

namespace WebApplication1.Domain;

public record FullName
{
    public string FirstName { get; init; } = null!;
    public string? MiddleName { get; init; }
    public string LastName { get; init; } = null!;

    private FullName() { }

    public FullName(string firstName, string? middleName, string lastName)
    {
        if (string.IsNullOrWhiteSpace(firstName))
            throw new RequiredDataException("The first name is required.");

        if (string.IsNullOrWhiteSpace(lastName))
            throw new RequiredDataException("The last name is required.");
        
        FirstName = firstName.Trim();
        MiddleName = string.IsNullOrWhiteSpace(middleName) ? null : middleName.Trim();
        LastName = lastName.Trim();
    }
}
