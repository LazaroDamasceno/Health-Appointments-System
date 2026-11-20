using System.Text.RegularExpressions;
using WebApplication1.Domain.Exceptions;

namespace WebApplication1.Domain.BasicUser;

public partial record PhoneNumber
{

    private string Value { get; init; } = null!;

    private PhoneNumber() { }

    public PhoneNumber(string phoneNumber)
    {
        if (string.IsNullOrWhiteSpace(phoneNumber))
            throw new RequiredDataException("Phone number is required.");

        var valueCleaned = Value.Trim();

        if (!PhoneNumberRegex().IsMatch(valueCleaned))
            throw new InvalidFormatException("Invalid UK phone number format.");
        
        Value = valueCleaned;
    }

    [GeneratedRegex("\\[0-9]{11}")] 
    private static partial Regex PhoneNumberRegex();
}