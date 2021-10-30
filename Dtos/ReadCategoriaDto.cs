using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace AluraFlix.Dtos
{
    public class ReadCategoriaDto
    {
        [Key]
        [Required]
        public int Id { get; set; }
        [Required(ErrorMessage = "O campo Titulo  é obrigatório")]
        public string Titulo { get; set; }
        [Required(ErrorMessage = "A Escolha da cor é obrigatória")]
        public string Cor { get; set; }
    }
}
