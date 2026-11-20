using System.Text.RegularExpressions;
using WebApplication1.Domain.Exceptions;

namespace WebApplication1.Domain;

public partial record Address
{

    private string AddressLine { get; init; } = null!;
    private string City { get; init; } = null!;
    private string PostCode { get; init; } = null!;

    public Address(string AddressLine, string City, string PostCode)
    {
        if (string.IsNullOrWhiteSpace(AddressLine))
            throw new RequiredDataException("Address line is required.");
        
        if (string.IsNullOrWhiteSpace(City))
            throw new RequiredDataException("City is required.");
        
        if (string.IsNullOrWhiteSpace(PostCode))
            throw new RequiredDataException("Post code is required.");

        if (!PostCodeRegex().IsMatch(PostCode))
            throw new InvalidFormatException("Post code is invalid.");
    }

    [GeneratedRegex(@"^[A-Z]{1,2}\d[A-Z\d]?\s\d[A-Z]{2}$", RegexOptions.IgnoreCase)]
    private static partial Regex PostCodeRegex();
}