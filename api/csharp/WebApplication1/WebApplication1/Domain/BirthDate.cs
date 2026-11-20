using WebApplication1.Domain.Exceptions;

namespace WebApplication1.Domain;

public partial record BirthDate
{
    public DateOnly Value { get; init; }

    public BirthDate(DateOnly birthDate)
    {
        if (birthDate == default)
            throw new RequiredDataException("Birth date is required.");

        if (!IsAtLeast18Yo(birthDate))
            throw new InvalidFormatException("It is necessary to be at least 18 years old."); 

        Value = birthDate;
    }

    private static bool IsAtLeast18Yo(DateOnly birthDate)
    {
        var today = DateOnly.FromDateTime(DateTime.Today);
        var minBirthDate = today.AddYears(-18);
        
        return birthDate <= minBirthDate;
    }
}