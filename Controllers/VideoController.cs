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
    public class VideoController : ControllerBase
    {
        private VideoContext _context;
        private IMapper _mapper;
        public VideoController(VideoContext context, IMapper mapper)
        {
            _context = context;
            _mapper = mapper;
        }

        [HttpPost]
        public IActionResult InsertVideo([FromBody] CreateVideoDto videoDto)
        {
            Video video = _mapper.Map<Video>(videoDto);

            _context.Videos.Add(video);
            _context.SaveChanges();
            return CreatedAtAction(nameof(GetById), new { Id = video.Id }, video); // Aqui indica qual é a action que vamos precisar executar para recuperar este recurso que estamos criando, o retorno também no caso de criação deverá ser sempre 201
        }

        [HttpGet]
        public IActionResult GetAllVideo([FromQuery] string? tituloVideos = null)
        {
            List<Video> videos;
            if (tituloVideos == null)
            {
                videos = _context.Videos.ToList();
            }
            else
            {
                videos = _context
                  .Videos.Where(video => video.Titulo == tituloVideos).ToList();
            }
            if (videos != null)
            {
                List<ReadVideoDto> readDto = _mapper.Map<List<ReadVideoDto>>(videos);
                return Ok(readDto);
            }
            return NotFound();


        }

        [HttpGet("{id}")]
        public IActionResult GetById(int id)
        {
            Video video = _context.Videos.FirstOrDefault(video => video.Id == id);
            if (video != null)
            {
                ReadVideoDto videoDto = _mapper.Map<ReadVideoDto>(video);
                return Ok(videoDto);
            }
            return NotFound();
        }

        [HttpPut("{id}")]
        public IActionResult UpdateVideo(int id, [FromBody] UpdateVideoDto videoDto)
        {
            Video video = _context.Videos.FirstOrDefault(video => video.Id == id);
            if (video == null)
            {
                return NotFound();
            }
            _mapper.Map(videoDto, video);
            _context.SaveChanges();
            return NoContent();
        }

        [HttpDelete("{id}")]
        public IActionResult DeleteVideo(int id)
        {
            Video video = _context.Videos.FirstOrDefault(video => video.Id == id);
            if (video == null)
            {
                return NotFound();
            }
            _context.Remove(video);
            _context.SaveChanges();
            return NoContent();
        }
    }
}
