using System.Text.RegularExpressions;
using WebApplication1.Domain.Exceptions;

namespace WebApplication1.Domain.BasicUser;

public partial record Identifier
{

    public string Value { get; init; } = null!;

    private Identifier() { }

    public Identifier(string identifier)
    {
        if (string.IsNullOrWhiteSpace(identifier))
            throw new RequiredDataException("Identifier is required.");

        var valueCleaned = identifier.Trim();
        
        if (IdentifierRegex().IsMatch(valueCleaned))
            throw new InvalidFormatException("Identifier is invalid.");
        
        Value = valueCleaned;
    }

    [GeneratedRegex(@"\[Aa-Zz]\d{6}\[Aa-Zz]{2}")]
    private static partial Regex IdentifierRegex();
}