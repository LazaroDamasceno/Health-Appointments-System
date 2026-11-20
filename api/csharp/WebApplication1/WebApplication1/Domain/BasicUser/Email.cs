using System.Text.RegularExpressions;
using WebApplication1.Domain.Exceptions;

namespace WebApplication1.Domain.BasicUser;

public partial class Email
{

    private string Value { get; init; } = null!;

    private Email() { }

    public Email(string email)
    {
        if (string.IsNullOrWhiteSpace(email))
            throw new RequiredDataException("Email is required.");

        var valueCleaned = Value.Trim();

        if (!EmailRegex().IsMatch(valueCleaned))
        {
            throw new InvalidFormatException("Email is invalid.");
        }
        
        Value = valueCleaned;
    }

    [GeneratedRegex(@"^[^@\s]+@[^@\s]+\.[^@\s]+$", RegexOptions.IgnoreCase)]
    private static partial Regex EmailRegex();
}