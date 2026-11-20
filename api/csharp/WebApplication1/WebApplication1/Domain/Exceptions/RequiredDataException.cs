namespace WebApplication1.Domain.Exceptions;

public class RequiredDataException(string message): Exception(message);