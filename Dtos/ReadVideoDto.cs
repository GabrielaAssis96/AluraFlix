using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace AluraFlix.Dtos
{
    public class ReadVideoDto
    {
        [Key]
        [Required]
        public int Id { get; set; }
        [Required(ErrorMessage = "O campo Titulo é obrgatório")]
        public string Titulo { get; set; }
        [Required(ErrorMessage = "O campo Descrição é obrgatório")]
        public string Descricao { get; set; }
        [Required(ErrorMessage = "O campo URL é obrgatório")]
        public string Url { get; set; }
        public DateTime HoraDaConsulta { get; set; }
    }
}
