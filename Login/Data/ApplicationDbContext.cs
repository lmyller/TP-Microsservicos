using AuthApi.Models;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;

namespace AuthApi.Data;

public class ApplicationDbContext : DbContext
{
    public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options)
    : base(options)
    {
    }

    public DbSet<User> Users => Set<User>();
}

