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

        public DbSet<Video> Videos { get; set; }
        public DbSet<Categoria> Categorias { get; set; }

    }
}
