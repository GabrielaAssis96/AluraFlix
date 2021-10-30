using AluraFlix.Dtos;
using AluraFlix.Models;
using AutoMapper;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AluraFlix.Profiles
{
    public class CategoriaProfile : Profile
    {
        public CategoriaProfile()
        {
            CreateMap<CreateCategoriaDto, Categoria>();
            CreateMap<UpdateCategoriaDto, Categoria>();
            CreateMap<Categoria, ReadCategoriaDto>();
        }
    }
}
