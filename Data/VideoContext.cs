using AluraFlix.Models;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AluraFlix.Data
{
    public class VideoContext : DbContext
    {
        public VideoContext(DbContextOptions<VideoContext> opt) : base(opt)
        {

        }

        protected override void OnModelCreating(ModelBuilder builder)
        {
            builder.Entity<Categoria>()
                .HasOne(Categorias => Categorias.Video)
                .WithOne(Videos => Videos.Categoria)
                .HasForeignKey<Video>(Videos => Videos.CategoriaId);
        }

        public DbSet<Video> Videos { get; set; }
        public DbSet<Categoria> Categorias { get; set; }

    }
}
