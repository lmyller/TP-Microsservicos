namespace AuthApi.Config;

public class JwtConfig
{
    public required string Secret { get; set; }
    public int ExpirationInDays { get; set; } = 365;
}

