using System.ComponentModel.DataAnnotations;

namespace AuthApi.Models;

public class User
{
    public int Id { get; set; }

    [Required]
    [EmailAddress]
    public required string Email { get; set; }

    [Required]
    public required string PasswordHash { get; set; }
}

