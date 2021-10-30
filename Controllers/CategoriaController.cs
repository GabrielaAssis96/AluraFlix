using AluraFlix.Data;
using AluraFlix.Dtos;
using AluraFlix.Models;
using AutoMapper;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AluraFlix.Controllers
{
    [ApiController]
    [Route("[Controller]")]
    public class CategoriasController : Controller
    {
        private VideoContext _context;
        private IMapper _mapper;
        public CategoriasController(VideoContext context, IMapper mapper)
        {
            _context = context;
            _mapper = mapper;
        }

        [HttpPost]
        public IActionResult InsertCategoria(CreateCategoriaDto categoriaDto)
        {
            Categoria categoria = _mapper.Map<Categoria>(categoriaDto);
            _context.Categorias.Add(categoria);
            _context.SaveChanges();
            return CreatedAtAction(nameof(GetById), new { id = categoria.Id }, categoria);
        }

        [HttpGet]
        public IEnumerable<Categoria> GetAllCategoria()
        {
            return _context.Categorias;
        }

        [HttpGet("{id}")]
        public IActionResult GetById(int id)
        {
            Categoria categoria = _context.Categorias.FirstOrDefault(categoria => categoria.Id == id);
            if(categoria != null)
            {
                ReadCategoriaDto categoriaDto = _mapper.Map<ReadCategoriaDto>(categoria);
                return Ok(categoriaDto);
            }
            return NotFound();

        }

        [HttpPut("{id}")]
        public IActionResult UpdateCategoria(int id, [FromBody] UpdateCategoriaDto categoriaDto)
        {
            Categoria categoria = _context.Categorias.FirstOrDefault(categoria => categoria.Id == id);
            if(categoria == null)
            {
                return NotFound();
            }
            _mapper.Map(categoriaDto, categoria);
            _context.SaveChanges();
            return NoContent();
        }
    }
}
